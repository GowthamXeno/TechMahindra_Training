import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ExpenditureService {
  private apiUrl = 'http://localhost:4500';

  constructor(private http: HttpClient) {}

  getUserById(userId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/users/${userId}`);
  }

  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/users`);
  }

  updateUserDebts(users: any[], expense: any): any[] {
    console.log("🚀 updateUserDebts called with users:", users, "and expense:", expense);

    let payer = users.find((u: any) => u.id == expense.userId);
    if (!payer) {
      console.log("❌ Payer not found!");
      return users;
    }

    console.log("✅ Payer found:", payer);

    expense.splitAmong.forEach((contributorId: number) => {
      if (contributorId !== expense.userId) {
        let contributor = users.find((u: any) => u.id == contributorId);
        if (!contributor) {
          console.log("❌ Contributor", contributorId, "not found!");
          return;
        }

        console.log("✅ Contributor found:", contributor);

        let owedAmount = expense.owedDetails.find((detail: any) => detail.owedBy == contributorId)?.amount;
        if (owedAmount === undefined) {
          console.error("❌ owedAmount is undefined, check your owedDetails array in the expenditure object");
          console.log("Expense owedDetails:", expense.owedDetails);
          return;
        }

        console.log("💰 Owed amount:", owedAmount);

        // Update contributor's owesTo array
        contributor.owesTo = contributor.owesTo || [];
        let contributorDebt = contributor.owesTo.find((debt: any) => debt.userId === expense.userId);

        if (contributorDebt) {
          console.log("🔄 Updating contributor's owesTo:", contributor.owesTo);
          contributorDebt.amount = owedAmount;
          contributorDebt.expenseId = expense.id;
          console.log("✅ Updated contributor's owesTo:", contributor.owesTo);
        } else {
          console.log("➕ Adding to contributor's owesTo:", contributor.owesTo);
          contributor.owesTo.push({ userId: expense.userId, amount: owedAmount, expenseId: expense.id });
          console.log("✅ Added to contributor's owesTo:", contributor.owesTo);
        }

        // Update payer's owedBy array
        payer.owedBy = payer.owedBy || [];
        let payerDebt = payer.owedBy.find((debt: any) => debt.userId == contributorId);

        if (payerDebt) {
          console.log("🔄 Updating payer's owedBy:", payer.owedBy);
          payerDebt.amount = owedAmount;
          payerDebt.expenseId = expense.id;
          console.log("✅ Updated payer's owedBy:", payer.owedBy);
        } else {
          console.log("➕ Adding to payer's owedBy:", payer.owedBy);
          payer.owedBy.push({ userId: contributorId, amount: owedAmount, expenseId: expense.id });
          console.log("✅ Added to payer's owedBy:", payer.owedBy);
        }
      }
    });

    console.log("🏁 Updated users:", users);
    return users;
  }
  
  

  addExpenditure(expense: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/expenditures`, expense).pipe(
      switchMap((newExpense: any) =>
        this.getAllUsers().pipe(
          map((users) => this.updateUserDebts([...users], newExpense)),
          switchMap((updatedUsers: any[]) =>
            forkJoin(
              updatedUsers.map((user: any) =>
                this.http.put(`${this.apiUrl}/users/${user.id}`, user)
              )
            ).pipe(
              switchMap(() =>
                this.http.get<any[]>(`${this.apiUrl}/groups`).pipe(
                  map((groups) => this.updateGroupExpenditures([...groups], newExpense)),
                  switchMap((updatedGroups: any[]) =>
                    forkJoin(
                      updatedGroups.map((group: any) =>
                        this.http.put(`${this.apiUrl}/groups/${group.id}`, group)
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    );
  }

  updateGroupExpenditures(groups: any[], expense: any): any[] {
    return groups.map((group: any) =>
      group.id === expense.groupId ? { ...group, expenditures: [...(group.expenditures || []), expense.id] } : group
    );
  }
}

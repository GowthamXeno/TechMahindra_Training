import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {
  private apiUrl = 'http://localhost:4500/users';
  private expensesUrl = 'http://localhost:4500/expenditures';

  constructor(private http: HttpClient) {}

  getUserData(userId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${userId}`);
  }

  getFriendData(friendId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${friendId}`);
  }

  getExpenditures(): Observable<any[]> {
    return this.http.get<any[]>(this.expensesUrl);
  }

  settleDebt(expenseId: number, amount: number): Observable<any> {
    return this.http.patch(`${this.expensesUrl}/${expenseId}`, { amount: 0 });
  }

  payDebt(userId: number, friendId: number): Observable<any> {
    return this.http.patch(`${this.apiUrl}/${userId}`, {
      owesTo: [],
      owedBy: []
    });
  }
}

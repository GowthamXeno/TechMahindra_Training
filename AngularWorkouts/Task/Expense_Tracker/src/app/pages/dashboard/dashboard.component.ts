import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../../services/friends.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  friends: { id: number; username: string; owesToAmount: number; owedByAmount: number }[] = [];
  selectedFriend: any | null = null;
  selectedFriendExpenses: any[] = [];
  totalOwes = 0;
  totalOwed = 0;
  currentUserId: number = 1;

  constructor(private friendsService: FriendsService) {}

  ngOnInit() {
    this.loadDashboardData();
  }

  loadDashboardData() {
    this.friendsService.getUserData(this.currentUserId).subscribe(user => {
      if (!user.friends || user.friends.length === 0) {
        this.friends = [];
        return;
      }

      const friendRequests = user.friends.map((friendId: number) =>
        this.friendsService.getFriendData(friendId).toPromise().then(friendData => {
          let totalOwesToAmount = 0;
          let totalOwedByAmount = 0;

          if (user.owesTo) {
            user.owesTo.forEach((owed: any) => {
              if (owed.userId === friendId) totalOwesToAmount += owed.amount;
            });
          }

          if (user.owedBy) {
            user.owedBy.forEach((owed: any) => {
              if (owed.userId === friendId) totalOwedByAmount += owed.amount;
            });
          }

          this.totalOwes += totalOwesToAmount;
          this.totalOwed += totalOwedByAmount;

          return {
            id: friendId,
            username: friendData?.username || 'Unknown',
            owesToAmount: totalOwesToAmount,
            owedByAmount: totalOwedByAmount
          };
        })
      );

      Promise.all(friendRequests).then(friends => (this.friends = friends));
    }, error => console.error('Error fetching user data:', error));
  }

  viewFriendDetails(friendId: number) {
    console.log('Fetching details for Friend ID:', friendId);
  
    this.friendsService.getFriendData(friendId).subscribe(friend => {
      console.log('Friend Data:', friend);
      this.selectedFriend = friend;
  
      this.friendsService.getExpenditures().subscribe(expenses => {
        console.log('All Expenses:', expenses);
  
        this.selectedFriendExpenses = expenses.filter(expense => {
          return expense.owedDetails.some((detail: any) => {
            const isRelevant =
              (detail.payerId === this.currentUserId && detail.owedBy === friendId) ||
              (detail.payerId === friendId && detail.owedBy === this.currentUserId);
  
            if (isRelevant) {
              console.log(`Expense Found: ${expense.description}, Amount: ₹${expense.amount}`);
            }
            return isRelevant;
          });
        });
  
        console.log('Filtered Expenses for Friend:', this.selectedFriendExpenses);
      });
    });
  }
  
}

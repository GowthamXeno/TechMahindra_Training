import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../../services/friends.service';
import { forkJoin } from 'rxjs';

interface Debt {
  userId: number | string;
  amount: number;
  expenseId: number;
}

interface OwedDetail {
  payerId: number | string;
  owedBy: number | string;
  amount: number;
}

interface ExpenseDetail {
  id: number;
  description: string;
  amount: number;
  timestamp: string;
  youPaid: boolean;
  theyPaid: boolean;
  expenseId: number;
  owedToYou: number;
  youOwe: number;
}

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  friends: { id: number; username: string; owesToAmount: number; owedByAmount: number }[] = [];
  selectedFriend: any | null = null;
  selectedFriendExpenses: any[] = [];
  currentUserId: number = 1;

  constructor(private friendsService: FriendsService) {}

  ngOnInit() {
    this.loadFriends();
  }

  loadFriends() {
    this.friendsService.getUserData(this.currentUserId).subscribe(user => {
      if (!user.friends || user.friends.length === 0) {
        this.friends = [];
        return;
      }
  
      const friendRequests = user.friends.map((friendId: number) =>
        this.friendsService.getFriendData(friendId).pipe().toPromise().then(friendData => {
          let totalOwesToAmount = 0;
          let totalOwedByAmount = 0;
  
          if (user.owesTo) {
            user.owesTo.forEach((owed: Debt) => {
              if (Number(owed.userId) === Number(friendId) && typeof owed.amount === 'number') {
                totalOwesToAmount += owed.amount;
              }
            });
          }
  
          if (user.owedBy) {
            user.owedBy.forEach((owed: Debt) => {
              if (Number(owed.userId) === Number(friendId) && typeof owed.amount === 'number') {
                totalOwedByAmount += owed.amount;
              }
            });
          }
  
          return {
            id: friendId,
            username: friendData?.username || 'Unknown',
            owesToAmount: totalOwesToAmount,
            owedByAmount: totalOwedByAmount
          };
        })
      );
  
      Promise.all(friendRequests).then(friends => (this.friends = friends));
    }, error => {
      console.error('Error fetching user data:', error);
    });
  }

  viewFriendDetails(friendId: number) {
    forkJoin({
      friend: this.friendsService.getFriendData(friendId),
      expenses: this.friendsService.getExpenditures()
    }).subscribe(({ friend, expenses }) => {
      this.selectedFriend = friend;
      this.selectedFriendExpenses = expenses
        .filter(expense => {
          return expense.owedDetails.some((detail: OwedDetail) =>
            (Number(detail.payerId) === Number(this.currentUserId) && Number(detail.owedBy) === Number(friendId)) ||
            (Number(detail.payerId) === Number(friendId) && Number(detail.owedBy) === Number(this.currentUserId))
          );
        })
        .map(expense => {
          const owedToYouDetail = expense.owedDetails.find((detail:OwedDetail) => Number(detail.payerId) === Number(friendId) && Number(detail.owedBy) === Number(this.currentUserId));
          const youOweDetail = expense.owedDetails.find((detail:OwedDetail)  => Number(detail.payerId) === Number(this.currentUserId) && Number(detail.owedBy) === Number(friendId));
  
          return {
            id: expense.id,
            description: expense.description,
            amount: expense.amount,
            timestamp: expense.timestamp,
            youPaid: expense.userId === this.currentUserId,
            theyPaid: expense.userId === friendId,
            expenseId: expense.id,
            owedToYou: owedToYouDetail ? owedToYouDetail.amount : 0,
            youOwe: youOweDetail ? youOweDetail.amount : 0
          };
        });
    }, error => {
      console.error('Error fetching friend details:', error);
    });
  }
}

import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ExpenditureService } from '../../services/expenditure.service';

@Component({
  selector: 'app-expenditure',
  templateUrl: './expenditure.component.html',
  styleUrls: ['./expenditure.component.css']
})
export class ExpenditureComponent implements OnInit {
  loggedInUserId = 1; 
  totalAmount = 0;
  description = '';
  payer: number = this.loggedInUserId;
  selectedFriends: number[] = [];
  splitType = '';
  splitValues: { [key: number]: number } = {};
  friends: { id: number; username: string }[] = [];

  constructor(
    private expenditureService: ExpenditureService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.getFriends();
  }

  getFriends() {
    this.expenditureService.getUserById(this.loggedInUserId).subscribe(user => {
      this.expenditureService.getAllUsers().subscribe(allUsers => {
        if (!user.friends || user.friends.length === 0) {
          console.warn("User has no friends! Check user.friends in DB.");
        }

        this.friends = user.friends
          .map((friendId: number) => {
            const friend = allUsers.find((u: { id: number; username: string }) => Number(u.id) === friendId);
            return friend || null;
          })
          .filter((friend: { id: number; username: string } | null): friend is { id: number; username: string } => friend !== null);

        this.friends.unshift({
          id: this.loggedInUserId,
          username: user.username || `User ${this.loggedInUserId}`
        });
      });
    }, error => {
      console.error("Error fetching user:", error);
    });
  }

  onTotalAmountChange() {
    this.calculateSplit();
    this.cdr.detectChanges();
  }

  calculateSplit() {
    this.splitValues = {};

    if (this.splitType === 'equal' && this.selectedFriends.length > 0) {
      const totalParticipants = this.selectedFriends.length;
      const equalShare = this.totalAmount / totalParticipants;

      this.selectedFriends.forEach(friend => {
        this.splitValues[friend] = parseFloat(equalShare.toFixed(2));
      });

      this.splitValues[this.payer] = parseFloat(equalShare.toFixed(2));
    }

    this.cdr.detectChanges();
  }

  adjustSplit(friendId: number) {
    let newInputValue = Number(this.splitValues[friendId]) || 0; 

    if (this.splitType === 'manual') {

      if (newInputValue > this.totalAmount) {
        alert("Total split cannot exceed the total amount.");
        this.splitValues[friendId] = this.totalAmount;
        return;
      }

      // Distribute remaining amount among other friends
      let remainingAmount = this.totalAmount - newInputValue;
      let remainingFriends = this.selectedFriends.filter(id => id !== friendId);

      if (remainingFriends.length > 0) {
        let splitValue = remainingAmount / remainingFriends.length;
        remainingFriends.forEach(friend => {
          this.splitValues[friend] = parseFloat(splitValue.toFixed(2));
        });
      }
    }
  }

  resetSplitValues() {
    this.splitValues = {};
  }

  addExpenditure() {
    console.log("🚀 Current split values:", this.splitValues);

    const newExpenditure = {
      id: Math.floor(Math.random() * 1000),
      userId: this.payer || null,
      groupId: 1,
      amount: this.totalAmount ? parseFloat(this.totalAmount.toFixed(2)) : 0,
      description: this.description || "No Description",
      splitAmong: this.selectedFriends.map(friend => Number(friend)),
      owedDetails: this.selectedFriends.map(friend => ({
        payerId: this.payer || null,
        owedBy: Number(friend),
        amount: this.splitValues[friend] ? parseFloat(this.splitValues[friend].toFixed(2)) : 0,
      })),
      timestamp: new Date(),
    };

    console.log("🚀 Data before sending:", newExpenditure);

    if (!newExpenditure.userId || !newExpenditure.amount) {
      console.error("❌ Missing required fields:", newExpenditure);
      return;
    }

    this.expenditureService.addExpenditure(newExpenditure).subscribe(response => {
      console.log("✅ Expenditure added:", response);
    }, error => {
      console.error("❌ Error adding expenditure:", error);
    });
  }

  getFriendName(id: number) {
    return this.friends.find(f => f.id === id)?.username || `User ${id}`;
  }
}
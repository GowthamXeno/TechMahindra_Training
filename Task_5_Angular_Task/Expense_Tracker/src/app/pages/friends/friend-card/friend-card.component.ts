import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-friend-card',
  templateUrl: './friend-card.component.html',
  styleUrls: ['./friend-card.component.css']
})
export class FriendCardComponent {
  @Input() friend: any;
  @Output() friendSelected = new EventEmitter<number>();

  selectFriend() {
    this.friendSelected.emit(this.friend.id);
  }
}

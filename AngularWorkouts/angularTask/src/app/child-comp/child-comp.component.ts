import { Component, EventEmitter, Input,OnChanges, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-child-comp',
  templateUrl: './child-comp.component.html',
  styleUrl: './child-comp.component.css'
})
export class ChildCompComponent {
  @Input('item') ReceivedItem :string =''; 
  @Output('send') SendItem : EventEmitter<string> = new EventEmitter<string>();
  mobileBrand: string[] = [];
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['ReceivedItem'] && changes['ReceivedItem'].currentValue) {
      this.mobileBrand.push(this.ReceivedItem);
    }
}

  sendData(brand : string){
    this.mobileBrand = this.mobileBrand.filter((item) => item!==brand);
    this.SendItem.emit(brand);
  }
}

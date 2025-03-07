import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'angularTask';
  selectedItem :string = '';
  mobileBrand: string[] = [
    'Apple',
    'Samsung',
    'OnePlus',
    'Xiaomi',
    'Realme',
    'Oppo',
    'Vivo',
    'Google',
    'Sony',
    'Asus',
    'Motorola',
    'Nokia',
    'Huawei',
    'Lenovo',
    'Nothing',
  ];


  sendData(brand : string){
    this.mobileBrand = this.mobileBrand.filter((item) => item !== brand);
    this.selectedItem = brand;
  }

  ReceiveData(brand : string){
    this.mobileBrand = [...this.mobileBrand,brand];
  }
  
}

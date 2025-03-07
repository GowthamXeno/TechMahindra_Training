import { Component } from '@angular/core';
import { str } from 'ajv';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'angularapp';
  appname: string = 'MyAngularApp';
  selectedProduct : string = '';
  products: string[] = [
    'Laptop',
    'Smartphone',
    'Tablet',
    'Monitor',
    'Keyboard',
    'Mouse',
    'Printer',
    'Scanner',
    'Webcam',
    'Headphones',
    'Speakers',
    'Microphone',
    'External Hard Drive',
    'USB Flash Drive',
    'Router',
    'Modem',
    'Graphics Card',
    'Motherboard',
    'CPU',
    'RAM',
    'Power Supply',
    'Cooling Fan',
    'Case',
    'Laptop Bag',
    'Smartwatch',
    'Fitness Tracker',
    'VR Headset',
    'Drone',
    'Camera',
    'Tripod',
  ];
  messages = [
    'Talk is cheap. Show me the code. - Linus Torvalds',
    'Programs must be written for people to read, and only incidentally for machines to execute. - Harold Abelson',
    'Any fool can write code that a computer can understand. Good programmers write code that humans can understand. - Martin Fowler',
    'First, solve the problem. Then, write the code. - John Johnson',
    'Experience is the name everyone gives to their mistakes. - Oscar Wilde',
  ];

  ReceiveData(product :string){
    this.selectedProduct = product;
  }
}

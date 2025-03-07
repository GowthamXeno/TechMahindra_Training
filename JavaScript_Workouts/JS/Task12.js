// 12. Get 2 numbers. Display the multiplication table of the first number till second number. For example, if the numbers are 5 and 7, then the table should display from 5*1=5 to 5*7=35

//12

var Num1 = prompt("Enter the Number 1 : ");
var Num2 = prompt("Enter the Number 2 : ");

for(i = 1 ; i <= Num2 ; i ++){
    console.log(Num1 + " * " + i + " = "+(Num1*i));
}

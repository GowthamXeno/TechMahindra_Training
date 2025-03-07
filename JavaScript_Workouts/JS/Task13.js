// 13. Get 2 numbers. Have the third number as second number + 40. Using while loop, display the multiples of first number from second number to third number. For example , if the numbers are 7, 20, first number is 7, second number is 20 and third number is 20+40, which is 60. So, Multiples of 7 should be displayed from 20 to 60, using while loop

// 13

var number1 = prompt("Enter the Number 1 :");
var number2 = prompt("Enter the Number 2 : ");
var number3 = number2 + 40;

while(number2 <= number3){
    if(number2 % 7 == 0){
        console.log(number2);
    }
    number2++;
}

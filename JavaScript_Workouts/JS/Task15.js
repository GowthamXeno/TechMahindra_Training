// 15.Get 2 numbers with interval 50. For example 10,60. Display the values from 10 to 60, but skip displaying the multiples of 5.

var number1 = prompt("Enter the Number 1 :");
var number2 = prompt("Enter the Number 2 with interval of 50 with number 1: ");

while (number1 <= number2) {
  if (number1 % 5 == 0) continue;
  console.log();
}

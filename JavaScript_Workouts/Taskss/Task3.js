// 3. Pass a number, and find if the sum of their digits is an even or odd number

function oddOrEven(num) {
  var sum = 0;
  while (num > 0) {
    sum += num % 10;
    num = parseInt(num / 10);
  }

  return sum % 2 == 0;
}

console.log(oddOrEven(24) ? "Even" : "Odd");

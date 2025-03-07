// 4. Create a arrow function without parameters, to choose the operation among add, subtract, multiply and divide, using switch statement.
// On choosing the operation, it has to invoke the corresponding method (as expression) with parameters and display the results accordingly, like, sum for add, difference for subtract, product for multiply, quotient and reminder for divide
var callOperation = () => {
  var operation = 4;
  var a = 10;
  var b = 5;

  switch (operation) {
    case 1:
      add(a, b);
      break;
    case 2:
      sub(a, b);
      break;
    case 3:
      multiply(a, b);
      break;
    case 4:
      divide(a, b);
      break;
    default:
      break;
  }
};

function add(a, b) {
  console.log("The Added Number is " + (a + b));
}
function sub(a, b) {
  console.log("The Subtracted Number is " + (a - b));
}
function multiply(a, b) {
  console.log("The Multiplied Value is " + a * b);
}
function divide(a, b) {
  console.log("The Quotient is " + parseInt(a / b));
  console.log("The Remainder is " + (a % b));
}

callOperation();

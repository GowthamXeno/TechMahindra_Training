// 11. Get the day of a week and perform the following using switch statement. If its Monday, display "Start of the week!" If its Tuesday, Wednesday or Thursday, display "Mid of the week!". If its Friday, display "Last working day of the week!". If its Saturday, display "WeekEnd - Saturday!". If its Sunday, display "WeekEnd - Sunday!".  If the input is not a day of the week, display "Invalid input!".

// 11

var day = prompt("Enter the Day of the week (Example Monday) : ");
switch (day) {
  case "Monday":
    console.log("Start of the week!");
    break;
  case "Tuesday" :
  case "Wednesday" :
  case "Thursday":
    console.log("Mid of the week!");
    break;
  case "Friday":
    console.log("Last working day of the week!");
    break;
  case "Saturday":
    console.log("WeekEnd - Saturday!");
    break;
  case "Sunday":
    console.log("WeekEnd - Sunday!");
    break;
  default:
    console.log("Invalid input!");
}

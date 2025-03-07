// 8. Get the price of 1 kg tomato from Monday to Sunday, find its average. If the average is greater than Rs.50, then display, tomato has given good profit. If not, display "No profit from tomato"

var totalPrice = 0;

var Weeks = ["Monday", "Tueday", "Wednesday", "Thurday", "Friday", "Saturday", "Sunday"];

for (i = 0; i < 7; i++) {
    totalPrice += Number(prompt("Enter the Price of Tomato On "+Weeks[i] +" : "));
}
console.log(
    totalPrice / 7 > 50 ? "Tomato has given good profit" : "No profit from tomato"
);

console.log(totalPrice);

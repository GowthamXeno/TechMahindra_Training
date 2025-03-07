// 3. Create a variable as const, check if its a prime number or not, and display the result accordingly

//3

const c = 4;

function IsPrime(num) {
    if (num < 2)
        return false;
    else {
        for (i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

console.log(IsPrime(c) ? "The Given Number is Prime " : "The Given Number is not Prime")

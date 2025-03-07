// 2. Pass a parameter, and display the factors of that parameter in the function

function findFactor(num) {
var factors = new Array();
    for(i = 1 ; i <= num ; i ++){
        if(num % i == 0){
            factors.push(i);
        }
    }
    return factors;
}

console.log(findFactor(24));

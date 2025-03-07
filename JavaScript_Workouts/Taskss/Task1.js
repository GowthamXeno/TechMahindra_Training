// 1. Without paasing parameters, display the multiplication table with two variables , one variable for the number , and other for the limit.



function multiplication(number,limit) {
    for(i = 1 ; i <= limit ; i ++){
        console.log(i + " * "+number + " = "+(number*i));
    }
}

multiplication(7,10);

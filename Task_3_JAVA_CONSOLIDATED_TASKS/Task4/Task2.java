// 2. Write a Java program to create a method that takes an integer as a parameter and throws an exception if
// the number is odd.

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Any Number  :");
        int num = scan.nextInt();
        try{
            CheckOddNumber(num);
            System.out.println("The Number is Even");
        }catch(OddNumberException e){
            System.out.println(e.getMessage());
        }
    }
    public static void CheckOddNumber(int num) throws OddNumberException{
        if(num % 2 != 0){
            throw new OddNumberException("The Given Number "+num+" is OddNumber");
        }
    }
}

class OddNumberException extends Exception{
    OddNumberException(String msg){
        super(msg);
    }
}

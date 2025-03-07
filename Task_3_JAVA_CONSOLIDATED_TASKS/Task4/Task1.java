// 1. Write a Java program that throws an exception and catch it using a try-catch block.

public class Task1 {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

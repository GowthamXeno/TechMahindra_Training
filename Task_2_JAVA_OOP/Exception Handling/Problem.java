import java.util.Scanner;

public class Problem {

    public static void processInput(double number) {

        try {
            if (number == 0) {
                throw new ArithmeticException("Reciprocal of zero is undefined.");
            }

            double reciprocal = 1 / number;
            System.out.println("Reciprocal: " + reciprocal);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Finnaly Block");;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();
        processInput(number);
    }
}

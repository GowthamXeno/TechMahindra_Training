// Task 5 :You are requiredtocreate a string andcaptialize every alternative character. for
// eg :ifthe inputis anurag then outputshould be AnUrAg

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the String : ");

        String input = scan.next().toLowerCase();
        char[] output = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char CurrentChar = input.charAt(i);
            if (i % 2 == 0) {
                CurrentChar -= 32;
            }
            output[i] = CurrentChar;
        }
        System.out.println("The Modified String is " + String.valueOf(output));
    }
}

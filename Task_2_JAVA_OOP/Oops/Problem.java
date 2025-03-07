import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Numerator = scan.nextInt();
        int Denominator = scan.nextInt();

        int Quotient = 0;
        int remainder = Numerator;
        while(remainder >= Denominator){
            remainder = remainder - Denominator;
            Quotient++;
        }
        System.out.println("Qoutient : "+Quotient);
        System.out.println("Remainder : "+remainder);
    }
}

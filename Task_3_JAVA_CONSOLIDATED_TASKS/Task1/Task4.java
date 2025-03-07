// Task 4 :Use ArrayCopyRange() function to demonstrate and example such that you copy the range of values in an
// array.

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] OriginalArray = {1,2,3,4,5,6,8,9,0};

        int[] newArray = Arrays.copyOfRange(OriginalArray, 2, 6);

        System.out.print("The Sliced Array Using CopyRange method : "+Arrays.toString(newArray));
    }

}

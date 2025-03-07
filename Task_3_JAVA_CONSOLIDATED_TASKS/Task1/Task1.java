// Task 1:Write a Java program to copy the alternative elements in the array.

import java.util.*;

class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter The size of the Array");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of Array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[] AlternativeArray = alternativeArray(arr);
        System.out.println("The Alternative Copied Elements are : ");
        System.out.println(Arrays.toString(AlternativeArray));
    }

    public static int[] alternativeArray(int[] arr) {
        int[] altArr = new int[(arr.length + 1) / 2];

        for (int i = 0, j = 0; i < arr.length; i += 2) {
            altArr[j++] = arr[i];
        }
        return altArr;
    }
}

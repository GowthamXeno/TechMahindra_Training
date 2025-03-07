// 5. Write a Java program that calculates the sum of all prime numbers up to a given limit using multiple threads.

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = scan.nextInt();

        int numThreads = 4; 
        PrimeSumThread[] threads = new PrimeSumThread[numThreads];
        int range = limit / numThreads;
        int start = 2;

        for (int i = 0; i < numThreads; i++) {
            int end = (i == numThreads - 1) ? limit : start + range - 1;
            threads[i] = new PrimeSumThread(start, end);
            threads[i].start();
            start = end + 1;
        }

        int totalSum = 0;
        for (PrimeSumThread thread : threads) {
            thread.join();
            totalSum += thread.getSum();
        }

        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}

class PrimeSumThread extends Thread {
    private final int start, end;
    private int sum = 0;

    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }

    public int getSum() {
        return sum;
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

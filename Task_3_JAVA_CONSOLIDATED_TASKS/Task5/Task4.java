// 4. Write a Java program that performs matrix multiplication using multiple threads

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] B = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };

        int[][] result = new int[A.length][B[0].length];

        Thread[] threads = new Thread[A.length];

        for (int i = 0; i < A.length; i++) {
            threads[i] = new Thread(new MatrixMultiplicationTask(A, B, result, i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class MatrixMultiplicationTask implements Runnable {
    private final int[][] A, B, result;
    private final int row;

    public MatrixMultiplicationTask(int[][] A, int[][] B, int[][] result, int row) {
        this.A = A;
        this.B = B;
        this.result = result;
        this.row = row;
    }

    @Override
    public void run() {
        for (int j = 0; j < B[0].length; j++) {
            result[row][j] = 0;
            for (int k = 0; k < A[0].length; k++) {
                result[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

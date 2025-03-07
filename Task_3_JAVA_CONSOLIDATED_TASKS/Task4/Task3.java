// 3. Write a Java program to create a method that reads a file and throws an exception if the file is not found.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task\\Task3\\SampleText.txt";
        try {
            FileRead(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void FileRead(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }
}

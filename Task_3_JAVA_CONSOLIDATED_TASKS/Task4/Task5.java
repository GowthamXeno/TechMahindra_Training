// 5. Write a Java program that reads a file and throws an exception if the file is empty.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task\\Task4\\EmptyFile.txt";
        try {
            readFile(path);
            System.out.println("File is not empty.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String path) throws FileNotFoundException, EmptyFileException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("The specified file does not exist.");
        }

        if (file.length() == 0) {
            throw new EmptyFileException("The file is empty.");
        }

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }
}

class EmptyFileException extends Exception {
    EmptyFileException(String message) {
        super(message);
    }
}

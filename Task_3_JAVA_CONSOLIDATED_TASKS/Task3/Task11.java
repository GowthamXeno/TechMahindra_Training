// 11. Write a Java program to read a plain text file.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task\\Task3\\SampleText.txt";

        try{
            List<String> lineList = Files.readAllLines(Paths.get(path));
            System.out.println("File content:");
            for (String line : lineList) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

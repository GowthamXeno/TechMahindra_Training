// 4. Write a Java program to check if a file or directory has read and write permissions.

import java.io.File;

public class Task4 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task"; 

        File fileOrDirectory = new File(path);

        if (fileOrDirectory.exists()) {
            System.out.println("Read permission: " + (fileOrDirectory.canRead() ? "Yes" : "No"));
            System.out.println("Write permission: " + (fileOrDirectory.canWrite() ? "Yes" : "No"));
        } else {
            System.out.println("The specified file or directory does not exist.");
        }
    }
}

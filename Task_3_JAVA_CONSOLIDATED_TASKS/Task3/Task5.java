// 5. Write a Java program to check if the given pathname is a directory or a file.

import java.io.File;

public class Task5 {
    public static void main(String[] args) {
        String path1 = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task";
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task\\Task3\\Task1.java";

        File fileOrDirectory = new File(path);
        if(fileOrDirectory.exists()){
            if(fileOrDirectory.isDirectory()){
                System.out.println("The File Path mentioned Above is Directory");
            }
            if(fileOrDirectory.isFile()){
                System.out.println("The File Path mentioned Above is A File!");
            }
        }
        else{
            System.out.println("No Directory Exists");
        }
    }
}

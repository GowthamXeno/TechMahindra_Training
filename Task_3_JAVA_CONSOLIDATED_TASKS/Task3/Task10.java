// 10. Write a Java program to read file content line by line.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task10 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task\\Task3\\SampleText.txt";


        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line ;
            System.out.println("File Content Read by Line by Line : ");
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

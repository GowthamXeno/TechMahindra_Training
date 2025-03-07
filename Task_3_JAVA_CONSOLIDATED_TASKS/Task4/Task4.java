// 4. Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers
// are positive.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gowth\\OneDrive\\Desktop\\TechM-Training\\11__21-02-2025 Task\\Task4\\NumberFile.txt";
        try {
            ReadNumberFromFile(path);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (PostiveNumberException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void ReadNumberFromFile(String path) throws FileNotFoundException, PostiveNumberException{
        File file = new File(path);
        Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                if(scan.hasNextInt()){
                    if(scan.nextInt() > 0){
                        throw new PostiveNumberException("The File have postive Numbers ");
                    }
                }else{
                    scan.next();
                }
            }

    }
}


class PostiveNumberException extends Exception{
    PostiveNumberException(String msg){
        super(msg);
    }
}

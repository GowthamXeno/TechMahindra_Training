package Serielizable_Task.Student;
import java.io.*;

public class ObjectInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("Databse.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            Student s1 = (Student) in.readObject();
            System.out.println("S Name : " + s1.Name + " , S Age : " + s1.age );
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

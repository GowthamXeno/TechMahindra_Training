package Serielizable_Task.Student;
import java.io.*;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {

        try {

            FileOutputStream fout = new FileOutputStream("Databse.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Student s1 = new Student("Gowtham", 21, "gowtham@gmail.com");

            out.writeObject(s1);
            out.flush();
            out.close();
            System.out.println("Success !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Student implements Serializable {
    String Name;
    int age;
    transient String email;

    public Student(String Name, int age, String email) {
        this.Name = Name;
        this.age = age;
        this.email = email;
    }

}

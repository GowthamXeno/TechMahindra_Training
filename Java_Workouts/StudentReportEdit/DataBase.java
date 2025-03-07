package StudentReportEdit;
import StudentReportEdit.Student;

import java.util.*;

public class DataBase {
    List<Student> studentList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public void Login(){
        System.out.println("--------Login Page---------");
        System.out.print("Enter Your Name : ");
        String Name = scan.next();
        System.out.println("Enter Your Email : ");
        String Email = scan.next();
        boolean login = false;
        for(Student s : studentList){
            if(s.getName().equals(Name) && s.getEmail().equals(Email)){
                System.out.println("Login Successfull ! "+s.getName());
                System.out.println("------------------------------------");
                login = true;
                Student.DisplayDetails(s);
                Student.StudentLoggedIn(s);
                break;
            }
        }
        if(!login){
            System.out.println("Invalid Credentials... Try Again");
        }
    }
    public void SignUp(){
        System.out.println("--------SignUp Page----------");
        System.out.print("Enter Name : ");
        String name = scan.next();
        System.out.print("Enter Student ID : ");
        int id = scan.nextInt();
        System.out.print("Enter Email : ");
        String email = scan.next();
        Student newStudent = new Student(name,id,email);
        studentList.add(newStudent);

        System.out.println("-------------------------------------------");
        System.out.println("Student Profile Registered Successfully !");
        System.out.println("-------------------------------------------");
        Student.DisplayDetails(newStudent);
    }
}

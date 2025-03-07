package StudentReportEdit;
import java.util.*;
public class Student {
    private String Name;
    private int ID;
    private String email;
    static Scanner scan = new Scanner(System.in);

    public Student(String name, int ID, String email) {
        this.Name = name;
        this.ID = ID;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void StudentLoggedIn(Student s){
        boolean login = true;
        while(login){
            System.out.println("Student Profile and Options : ");
            System.out.println("1-Buy Books");
            System.out.println("2-Edit Profile");
            System.out.println("3-Exit");
            switch (scan.nextInt()){
                case 1:
                    System.out.println("Temporarily Unavailabale ...");
                    break;
                case 2:
                    EditProfile(s);

                    break;
                case 3:
                    login = false;
                    break;
            }
        }
    }
    public static void DisplayDetails(Student s){
        System.out.println("Student Profile : ");
        System.out.println("Name : "+s.getName());
        System.out.println("Student ID : "+s.getID());
        System.out.println("Email : "+s.getEmail());
        System.out.println("-----------------------------------");
    }
    public static void EditProfile(Student s){
        boolean edited = true;
        while(edited){
            DisplayDetails(s);
            System.out.println("What Do you want to edit : ");
            System.out.println("1-Name");
            System.out.println("2-ID");
            System.out.println("3-Email");
            System.out.println("4-Done Editing");
            switch (scan.nextInt()){
                case 1:
                    System.out.print("Enter the new Name : ");
                    s.setName(scan.next());
                    System.out.println("Name is Changed Successfully!!!.");
                    break;
                case 2:
                    System.out.print("Enter the New Student ID : ");
                    s.setID(scan.nextInt());
                    System.out.println("Student ID is Changed Successfully");
                    break;
                case 3:
                    System.out.print("Enter the New Email : ");
                    s.setEmail(scan.next());
                    System.out.println("Email is Changed Successfully");
                    break;
                case 4:
                    edited = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try Again...");
            }
        };
    }
}

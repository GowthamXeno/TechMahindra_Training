package StudentReportEdit;
import CustomClass.Student;

import java.util.*;

public class LoginPage {
    private static DataBase StudentDB = new DataBase();

    public static void main(String[] args) {
        System.out.println("Welcome !");
        boolean logoff = false;
        while(!logoff){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Any options Below : ");
            System.out.println("1-Login");
            System.out.println("2-SignUp");
            System.out.println("3-Exit");
            switch (scan.nextInt()){
                case 1:
                    StudentDB.Login();
                    break;
                case 2:
                    StudentDB.SignUp();
                    break;
                case 3:
                    logoff = true;
                    break;
                default:
                    System.out.println("Invalid Input Try Again...");
            }
        }
    }
}

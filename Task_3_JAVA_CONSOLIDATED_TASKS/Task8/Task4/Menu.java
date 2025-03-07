import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.management.Query;

public class Menu {
    static String url = "jdbc:mysql://localhost:3306/company";
    static String username = "root";
    static String password = "gowtham";
    static Scanner in = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n-------Menu---------");
        System.out.println("1. Insert a new Row ");
        System.out.println("2. Update a Row");
        System.out.println("3. Delete a Row");
        System.out.println("4. Select the Row");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            menu();
            System.out.print("Enter your choice: ");
            ch = in.nextInt();

            try {
                Connection connect = DriverManager.getConnection(url, username, password);
                switch (ch) {
                    case 1: {
                        Query.insertRow(connect);
                        break;
                    }
                    case 2: {
                        Query.updateRow(connect);
                        break;
                    }
                    case 3: {
                        Query.deleteRow(connect);
                        break;
                    }
                    case 4: {
                        Query.selectRow(connect);
                        break;
                    }
                    case 5: {
                        System.out.println("Exit success");
                        break;
                    }
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}

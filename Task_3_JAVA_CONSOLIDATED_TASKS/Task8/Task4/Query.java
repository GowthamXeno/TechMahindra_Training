import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Query {
    static Scanner scanner = new Scanner(System.in);

    public static void insertRow(Connection connect) throws SQLException {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        String query = "INSERT INTO persons VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, address);
            pstmt.setString(5, city);
            System.out.println("Rows inserted: " + pstmt.executeUpdate());
        }
    }

    public static void updateRow(Connection connect) throws SQLException {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Address: ");
        String address = scanner.nextLine();

        String query = "UPDATE persons SET Address = ? WHERE PersonID = ?";
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            pstmt.setString(1, address);
            pstmt.setInt(2, id);
            System.out.println("Rows updated: " + pstmt.executeUpdate());
        }
    }

    public static void deleteRow(Connection connect) throws SQLException {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM persons WHERE PersonID = ?";
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            pstmt.setInt(1, id);
            System.out.println("Rows deleted: " + pstmt.executeUpdate());
        }
    }

    public static void selectRow(Connection connect) throws SQLException {
        System.out.print("Enter ID to view: ");
        int id = scanner.nextInt();

        String query = "SELECT * FROM persons WHERE PersonID = ?";
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("PersonID"));
                System.out.println("First Name: " + rs.getString("FirstName"));
                System.out.println("Last Name: " + rs.getString("LastName"));
                System.out.println("Address: " + rs.getString("Address"));
                System.out.println("City: " + rs.getString("City"));
            } else {
                System.out.println("No record found.");
            }
        }
    }
}

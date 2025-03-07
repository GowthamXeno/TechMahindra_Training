import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {

    static String url = "jdbc:mysql://localhost:3306/company";
    static String username = "root";
    static String password = "gowtham";
    static Scanner scanner = new Scanner(System.in);

    public static void updateEmployeeAddress(int empId, String newAddress) throws SQLException {
        String sql = "UPDATE Employee SET Address = ? WHERE EmployeeID = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newAddress);
            pstmt.setInt(2, empId);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        updateEmployeeAddress(empId, newAddress);
    }
}

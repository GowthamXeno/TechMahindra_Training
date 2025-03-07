

import java.sql.*;
import java.util.Scanner;

public class DeleteEmployee {

    static String url = "jdbc:mysql://localhost:3306/company";
    static String username = "root";
    static String password = "gowtham";
    static Scanner scanner = new Scanner(System.in);

    public static void deleteEmployeeById(int empId) throws SQLException {
        String deleteQuery = "DELETE FROM Employee WHERE EmployeeID = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, empId);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter Employee ID to delete: ");
        int empId = scanner.nextInt();
        try {
            deleteEmployeeById(empId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

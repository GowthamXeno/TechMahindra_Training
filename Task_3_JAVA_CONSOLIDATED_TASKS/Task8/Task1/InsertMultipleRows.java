

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMultipleRows {

    static String url = "jdbc:mysql://localhost:3306/company";
    static String username = "root";
    static String password = "gowtham";

    public static void main(String[] args) throws SQLException {
        Object[][] employeeData = {
                { 101, "Michael", "Jordan", "Basketball Court", "Chicago" },
                { 102, "Serena", "Williams", "Tennis Avenue", "Florida" },
                { 103, "Cristiano", "Ronaldo", "Soccer Street", "Madrid" },
                { 104, "Elon", "Musk", "Rocket Road", "Texas" },
                { 105, "Marie", "Curie", "Science Lane", "Paris" }
        };

        insertRows(employeeData);
    }

    public static void insertRows(Object[][] data) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insertQuery = "INSERT INTO persons VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                for (Object[] row : data) {
                    pstmt.setInt(1, (int) row[0]);
                    pstmt.setString(2, (String) row[1]);
                    pstmt.setString(3, (String) row[2]);
                    pstmt.setString(4, (String) row[3]);
                    pstmt.setString(5, (String) row[4]);
                    System.out.println("Rows affected: " + pstmt.executeUpdate());
                }
            }
        }
    }
}

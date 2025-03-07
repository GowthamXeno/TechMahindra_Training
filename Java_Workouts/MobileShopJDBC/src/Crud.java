import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud {
    public static void insertIphone(Iphone phone){
        String query = "Insert into iphone(MODEL, ROM, RAM, PRICE, BATTERY) values(?,?,?,?,?)";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,phone.getModel());
            stmt.setInt(2,phone.getRom());
            stmt.setInt(3,phone.getRam());
            stmt.setInt(4,phone.getPrice());
            stmt.setString(5,phone.getBattery());
            stmt.executeUpdate();
            System.out.println("Phone added successfully!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void DisplayPhone(){
        try(Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from iphone")){
                System.out.println("------------------------------------------------------------------");
            while(rs.next()){
                System.out.println("Model: " + rs.getString("MODEL") +
                        ", ROM: " + rs.getInt("ROM") +
                        ", RAM: " + rs.getInt("RAM") +
                        ", Price: " + rs.getInt("PRICE") +
                        ", Battery: " + rs.getString("BATTERY"));
            }
                System.out.println("------------------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

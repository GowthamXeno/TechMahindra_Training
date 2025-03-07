import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableAndDeserializable{
    public static void main(String[] args) {
        Employee E1 = new Employee(404,"Gowtham", "gowtham@gmail.com");

        try{
            FileOutputStream fout = new FileOutputStream("DatabaseStudent.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(E1);
            out.flush();
            out.close();
            System.out.println("Success the Object is Written in the file...");
        }catch(Exception e){
            System.out.println("Error in Output Stream : "+e.getMessage());
        }

        try{
            FileInputStream fin = new FileInputStream("DatabaseStudent.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            Employee E2 = (Employee)in.readObject();

            System.out.println("Employee Detials : ");
            System.out.println("EName : "+E2.Ename);
            System.out.println("Eno : "+E2.Eno);
            in.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Input Error : "+e.getMessage());
        }
    }
}

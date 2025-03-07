// Create a class Employee with fields Eno , Ename and email. Serialize the object of the class, without email field, store it, deserialize it and display the values

import java.io.Serializable;

public class Employee implements Serializable{
    int Eno;
    String Ename;
    transient String email;

    public Employee(int Eno, String Ename,String email) {
        this.Eno = Eno;
        this.Ename = Ename;
        this.email = email;
    }

}

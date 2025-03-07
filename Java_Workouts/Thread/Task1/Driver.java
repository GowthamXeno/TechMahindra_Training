// Create a class ThreadOne with 3 System.out.println("From ThreadOne!"); in its run method
// Create one separate thread and execute the above thread
public class Driver{
    public static void main(String[] args) {
            Thread t1 = new Thread(new GTask1ThreadOne());
            t1.start();
    }
}
class GTask1ThreadOne implements Runnable{
    public void run(){
        System.out.println("From GTask1ThreadOne");
        System.out.println("From GTask1ThreadOne");
        System.out.println("From GTask1ThreadOne");
    }
}

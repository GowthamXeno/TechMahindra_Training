// Create a class ThreadThree with 5 System.out.println("From ThreadThree!");  in its run method
// Create three separate threads and execute the above thread


public class Driver {
    public static void main(String[] args) {
        GTask3ThreadThree t1 = new GTask3ThreadThree();
        t1.start();
        GTask3ThreadThree t2 = new GTask3ThreadThree();
        t2.start();
        GTask3ThreadThree t3 = new GTask3ThreadThree();
        t3.start();
    }
}
class GTask3ThreadThree extends Thread{
    public void run(){
        System.out.println("From GTask3ThreadThree");
        System.out.println("From GTask3ThreadThree");
        System.out.println("From GTask3ThreadThree");
        System.out.println("From GTask3ThreadThree");
        System.out.println("From GTask3ThreadThree ");
    }
}

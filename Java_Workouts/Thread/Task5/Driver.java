// Create a class ThreadRunnableTwo with 3 System.out.println("From ThreadRunnableTwo!"); in its run method
// Create two separate threads and execute the above thread
public class Driver {
    public static void main(String[] args) {
        Thread T1 = new Thread(new GTask4ThreadRunnableTwo());
        T1.start();
        Thread T2 = new Thread(new GTask4ThreadRunnableTwo());
        T2.start();

    }
}

class GTask4ThreadRunnableTwo implements Runnable {
    public void run() {
        System.out.println("From GTask4ThreadRunnableTwo");
        System.out.println("From GTask4ThreadRunnableTwo");
        System.out.println("From GTask4ThreadRunnableTwo");
    }
}

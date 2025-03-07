// Create a class ThreadRunnableOne with 2 System.out.println("From ThreadRunnableOne!"); in its run method
// Create one separate thread and execute the above thread

public class Driver {
    public static void main(String[] args) {
        Thread T1 = new Thread(new GTask4ThreadRunnableOne());
        T1.start();

    }
}

class GTask4ThreadRunnableOne implements Runnable{
    public void run(){
        System.out.println("From GTask4ThreadRunnableOne");
        System.out.println("From GTask4ThreadRunnableOne");
    }
}

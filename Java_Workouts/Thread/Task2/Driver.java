// Create a class ThreadTwo with 2 System.out.println("From ThreadTwo!"); and one System.out.println(10/0); in its run method
// Create two separate threads and execute the above thread
// And execute the run method once from the main thread

public class Driver {
    public static void main(String[] args) {
        GTask2ThreadTwo t1 = new GTask2ThreadTwo();
        t1.start();
        GTask2ThreadTwo t2 = new GTask2ThreadTwo();
        t2.start();
    }
}


class GTask2ThreadTwo extends Thread{
    public void run(){
        System.out.println("From GTask2ThreadTwo!");
        System.out.println("From GTask2ThreadTwo!");
        System.out.println(10/0);
    }
}

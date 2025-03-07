package Workout;

public class Driver {
public static void main(String[] args) {//Thread 1
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
        System.out.println("From Main thread!");
GTask1Thread1 t1 = new GTask1Thread1();
        t1.start();//calls run method-Thread 2
      //t1.run();
GTask1Thread2 t2 = new GTask1Thread2();
        Thread tt2 = new Thread(t2);
        new Thread(t2).start();//Thread 3
        tt2.start();//Thread 4
        t2.run();

        System.out.println(10/0);
}
}

class GTask1Thread1 extends Thread {
    public void run() {
        System.out.println("From GTask1Thread1!" + this.getName());
        // System.out.println(10/0);
    }
}

class GTask1Thread2 implements Runnable
{
    public void run()
    {
        //System.out.println("From Thread2!");
        System.out.println(10/0);
    }
}

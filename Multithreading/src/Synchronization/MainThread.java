package Synchronization;

public class MainThread {
    public static void main(String[] args) {
        PrintTableUsingSyncMethod p = new PrintTableUsingSyncMethod();
        Thread t1 = new MyThread(p);
        Thread t2 = new MyThread(p);
        System.out.println("Main Thread Starts");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread Ends here");




    }
}

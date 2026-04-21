package Synchronization;

public class MainThreadUsingSyncBlock {
    public static void main(String[] args) {
        PrintTableUsingSyncBlock p1 = new PrintTableUsingSyncBlock();
        Thread t1 = new MyThreadUsingSyncBlock(p1);
        Thread t2 = new MyThreadUsingSyncBlock(p1);
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

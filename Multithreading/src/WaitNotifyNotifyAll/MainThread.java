package WaitNotifyNotifyAll;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        synchronized(t1){//main thread will syncronized and get lock because explicitly main is here but we cant create its object
            System.out.println("main thread called");
            System.out.println("main thread will be in waiting state");
            t1.wait();
            System.out.println("Total: "+t1.total);
            System.out.println("main thread ended here");

        }
    }
}
class MyThread extends Thread {
    public int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("child thread called");
            for (int i = 0; i < 100; i++) {
                total = total + i;
            }
            System.out.println("child thread ended");

            notify();// wake or notify waiting state thread to execute after all stmts execution of this synchronization block
            //notifyAll();
            System.out.println("main class wake up and start again due to notify calls");
            //since there are only two threads mainthread&Mythread so mainthread
            //will automatically execute after release of lock from mythread
        }
    }
}
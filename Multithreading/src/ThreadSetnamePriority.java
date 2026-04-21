class ItsThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }
}
public class ThreadSetnamePriority {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        t.setName("its main thread");
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        ItsThread t1 = new ItsThread();
        t1.start();//Each Thread can only start once only
        ItsThread t2 = new ItsThread();
        t2.setName("its child thread");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        ItsThread t3 = new ItsThread();
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();


    }
}

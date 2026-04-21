class MyThread extends Thread{
// no run method or overidden gives nothing due to not any printing implementation in run method in super thread method

    @Override
    public void run() {
        super.run();// not anything implementations in super thread run method
    }
}
public class RunMethodInThread {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for(int i=0; i<=5; i++){
            System.out.println("main thread");
        }
    }
}

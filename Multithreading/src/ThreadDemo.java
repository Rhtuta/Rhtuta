class Mythread1 extends Thread{
    @Override
    public void run() {
        for (int i=0; i<=5; i++){
            System.out.println("child run thread");
        }
        System.out.println("Current Thread Name: "+Thread.currentThread().getName());

    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        Mythread1 t = new Mythread1();
       // t.run();// doesn't create any thread and do normal execution only
        t.start();//to start a thread and responsible for creating a thread
        for (int i=0; i<=5; i++){
            System.out.println("main thread");
        }
    }
}

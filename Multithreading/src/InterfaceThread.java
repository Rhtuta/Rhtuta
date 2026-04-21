class MyTask implements Runnable{

    @Override
    public void run() {

    }
}
public class InterfaceThread {
    public static void main(String[] args) {
     Thread t = new Thread(new MyTask());// another method to create thread
     t.start();
    }
}

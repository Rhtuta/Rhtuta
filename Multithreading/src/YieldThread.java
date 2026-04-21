class Yield extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(getName()+"----"+i);
            Thread.yield();
        }
    }
}
public class YieldThread {
    public static void main(String[] args) {
        Yield t1 = new Yield();
        Yield t2 = new Yield();
        t1.start();
        t2.start();
    }
}

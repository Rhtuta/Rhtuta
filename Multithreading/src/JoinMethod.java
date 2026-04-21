class Join extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 10 ; i++) {
            System.out.println(getName()+"----"+i);
        }
    }
}
public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
      Join t1 = new Join();
      t1.start();
      t1.join();//jo thread ye line execute krega use hi is thread ke pura execute hone tk rukna pdega
        for (int i = 0; i <= 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"----"+i);
        }
    }
}

package Synchronization;

public class PrintTableUsingSyncBlock {
    public void printTable(int n){
        synchronized (this){//best way to synchronize is synchronizing a block not a method
            for (int i = 1; i <= 5  ; i++) {
                System.out.println(Thread.currentThread().getName()+" : "+ n*i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

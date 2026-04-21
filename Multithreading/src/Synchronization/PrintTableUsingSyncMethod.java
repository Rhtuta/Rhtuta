package Synchronization;

public class PrintTableUsingSyncMethod {
    public synchronized void printTable(int n){
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

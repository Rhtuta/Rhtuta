package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int bal = 2000;
    private final ReentrantLock rl = new ReentrantLock();
    public void withraw(String threadName, int amount){
        System.out.println(threadName+" is trying to withraw");
        rl.lock();
        if (rl.tryLock())// use without rl.trylock to show all users withrawing
        {
            //rl.lock();
            try {
                Thread.sleep(1000);
                System.out.println(threadName+ " aquired lock");
                if(amount<=bal){
                    bal = bal - amount;
                    System.out.println(threadName+" withrawn "+amount+" Rs and Remaining balance is : "+ bal);
                }
                else {
                    System.out.println("Insufficient balance");
                }
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                rl.unlock();
            }
        }
        else {
            System.out.println("Lock aquired by someone already now wait or do another work");
        }

    }
}
package Synchronization;

public class MyThread extends Thread{
    PrintTableUsingSyncMethod p;
    MyThread(PrintTableUsingSyncMethod p){
        this.p = p;
    }

    @Override
    public void run() {
        p.printTable(5);
    }
}

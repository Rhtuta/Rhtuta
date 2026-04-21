package Synchronization;

public class MyThreadUsingSyncBlock extends Thread{
    PrintTableUsingSyncBlock p;
    MyThreadUsingSyncBlock(PrintTableUsingSyncBlock p){
        this.p = p;
    }

    @Override
    public void run() {
        p.printTable(5);
    }
}

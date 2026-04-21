class Mythrd1 extends Thread{
    int sum = 0;
    //int i;
  synchronized public void add(int i) {//use synchronize to run one thread at a time by TS to remove inconsistancy
      sum = sum + i;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            add(i);
            //sum = sum + i;
        }
    }
}
class Mythrd2 extends Thread{
    Mythrd1 thrdref;
    Mythrd2(Mythrd1 thrdref){// passed Mythrd1 object
        this.thrdref = thrdref;//stored Mythrd1 object to call its add method
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
           thrdref.add(i);//called Mythrd1's call method
           // thrdref.sum = thrdref.sum + i;
        }
    }
}
public class ProblemThread {
    public static void main(String[] args) throws InterruptedException {
        Mythrd1 t1=new Mythrd1();
        Mythrd2 t2=new Mythrd2(t1);//pass Mythrd1 object to Mythrd2 in constructor to store thrdref
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("final answer: "+t1.sum);
    }
}

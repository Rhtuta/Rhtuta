package ExecutorService;

import Synchronization.MyThread;

public class CertificateSender implements Runnable{
    String stdName;
    CertificateSender(String stdName){
        this.stdName = stdName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Certificate sent to "+stdName+" by "
                + MyThread.currentThread().getName());
    }
}

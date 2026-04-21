package org.cfs;

public class Motor {

    public Motor() {
        System.out.println("org.cfs.Motor constructor....");
    }

    public void start(){
        System.out.println("org.cfs.Motor start....");
    }

    public void doWork(){
        System.out.println("org.cfs.Motor is pumping water");
    }

    public void stop(){
        System.out.println("org.cfs.Motor stops...");
    }
}

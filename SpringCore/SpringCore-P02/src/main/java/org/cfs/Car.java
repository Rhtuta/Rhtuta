package org.cfs;

public class Car {
    private Engine engine;
    public Engine getEngine() {
        return engine;
    }

    public Car() {
        System.out.println("car default constuctor ......");
    }

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("car constructor called and object created by IOC");
    }

    public void setEngine(Engine engine) {
        System.out.println("car setEngine .......");
        this.engine = engine;
    }

    public void drive(){
        int start = engine.start();
        if (start>=1){
            System.out.println("car is moving");
        }
        else
        {
            System.out.println("engine not started yet");
        }
    }
}

package org.cfs;

public class Car {
    private Engine engine;
    public Engine getEngine() {
        return engine;
    }

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("car constructor called and object created by IOC");
    }

    public void setEngine(Engine engine) {
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

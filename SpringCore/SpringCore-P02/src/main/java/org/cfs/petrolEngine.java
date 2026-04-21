package org.cfs;

public class petrolEngine implements Engine{
    public petrolEngine() {
        System.out.println("Petrol constructor called & object created by IOC");
    }

    @Override
    public int start() {
        return 1;
    }
}

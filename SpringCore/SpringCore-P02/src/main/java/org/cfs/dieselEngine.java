package org.cfs;

public class dieselEngine implements Engine{
    public dieselEngine() {
        System.out.println("diesel constructor called & object created by IOC");
    }

    @Override
    public int start() {
        return 1;
    }
}

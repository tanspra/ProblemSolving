package org.designpattern.factory;

public class MarutiCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Maruti Car assembled");
    }

    @Override
    public void run() {
        System.out.println("Maruti Car running");
    }
}

package org.designpattern.factory;

public class HyundaiCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Hyundai Car assembled");
    }

    @Override
    public void run() {
        System.out.println("Hyundai Car running");
    }
}

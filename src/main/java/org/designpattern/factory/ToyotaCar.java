package org.designpattern.factory;

public class ToyotaCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Toyota Car assembled");
    }

    @Override
    public void run() {
        System.out.println("Toyota Car running");
    }
}

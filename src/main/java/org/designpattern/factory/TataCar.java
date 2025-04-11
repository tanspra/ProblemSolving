package org.designpattern.factory;

public class TataCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Tata Car assembled");
    }

    @Override
    public void run() {
        System.out.println("Tata Car running");
    }
}

package org.test;

public class LionTest {
    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.roar();
        lion.name = "Indian Lion";
        lion.roar();
        Lion l1 = new Lion();
        l1 = lion;
        lion.roar();
        l1.roar();
        l1.name = "African";
        lion.roar();
        l1.roar();
    }
}

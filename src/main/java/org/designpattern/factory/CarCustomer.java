package org.designpattern.factory;

public class CarCustomer {
    public static void main(String[] args) {
        CarDealer carDealer = new CarDealer();
        carDealer.purchaseCar("toyota");
        carDealer.purchaseCar("maruti");
        carDealer.purchaseCar("tata");
        carDealer.purchaseCar("hyndai");
        carDealer.purchaseCar("hyndai1");
    }
}

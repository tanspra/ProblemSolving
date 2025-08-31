package org.designpattern.factory;

public class CarDealer {
    CarFactory carFactory = new CarFactory();
    public void purchaseCar(String carModel) {
        carFactory.createCar(carModel);
    }
}

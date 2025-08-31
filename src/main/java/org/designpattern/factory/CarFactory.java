package org.designpattern.factory;

public class CarFactory {
    public Car createCar(String carCompany) {
        Car car = switch (carCompany.toLowerCase()) {
            case "toyota" -> new ToyotaCar();
            case "maruti" -> new MarutiCar();
            case "tata" -> new TataCar();
            case "hyundai" -> new HyundaiCar();
            default -> throw new RuntimeException("Invalid car company: " + carCompany);
        };
        car.assemble();
        car.run();
        return car;
    }
}

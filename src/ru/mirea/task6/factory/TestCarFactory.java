package ru.mirea.task6.factory;

public class TestCarFactory {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car electricalCar = carFactory.buildElectricCar();
        Car mechanicalCar = carFactory.buildMechanicalCar();
        electricalCar.refuel();
        mechanicalCar.refuel();
    }
}

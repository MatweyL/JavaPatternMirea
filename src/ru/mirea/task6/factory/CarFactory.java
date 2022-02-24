package ru.mirea.task6.factory;

public class CarFactory {

    public Car buildMechanicalCar() {
        return new MechanicalCar();
    }

    public Car buildElectricCar() {
        return new ElectricCar();
    }
}

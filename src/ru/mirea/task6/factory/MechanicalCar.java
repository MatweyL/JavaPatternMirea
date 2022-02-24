package ru.mirea.task6.factory;

public class MechanicalCar implements Car {
    @Override
    public void refuel() {
        System.out.println("Наполнили бак бензином и счастливые сидим в авто)");
    }

    @Override
    public void drive() {
        System.out.println("Поехали ! ");
    }
}

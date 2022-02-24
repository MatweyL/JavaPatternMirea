package ru.mirea.task6.factory;

public class ElectricCar implements Car {

    @Override
    public void refuel() {
        System.out.println("Мы зарядили автомобиль!");
    }

    @Override
    public void drive() {
        System.out.println("Мы едем в соседнее село на дискотеку)))");
    }
}

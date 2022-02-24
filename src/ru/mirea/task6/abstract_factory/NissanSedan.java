package ru.mirea.task6.abstract_factory;

public class NissanSedan implements Sedan{
    @Override
    public void getCarInfo() {
        System.out.println("Это Nissan Sedan!");
    }

    @Override
    public void drive() {
        System.out.println("Nissan Sedan поехал!");
    }
}

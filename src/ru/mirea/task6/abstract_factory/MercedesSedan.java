package ru.mirea.task6.abstract_factory;

public class MercedesSedan implements Sedan{
    @Override
    public void getCarInfo() {
        System.out.println("Это Mercedes Sedan!");
    }

    @Override
    public void drive() {
        System.out.println("Mercedes Sedan поехал!");
    }
}

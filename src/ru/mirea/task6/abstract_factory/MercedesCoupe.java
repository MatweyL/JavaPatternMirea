package ru.mirea.task6.abstract_factory;

public class MercedesCoupe implements Coupe{
    @Override
    public void getCarInfo() {
        System.out.println("Это Mercedes Coupe");
    }

    @Override
    public void drive() {
        System.out.println("Mercedes Coupe поехал!");
    }
}

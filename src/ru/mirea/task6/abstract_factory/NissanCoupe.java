package ru.mirea.task6.abstract_factory;

public class NissanCoupe implements Coupe{
    @Override
    public void getCarInfo() {
        System.out.println("Это Nissan Coupe");
    }

    @Override
    public void drive() {
        System.out.println("Nissan Coupe поехал!");
    }
}

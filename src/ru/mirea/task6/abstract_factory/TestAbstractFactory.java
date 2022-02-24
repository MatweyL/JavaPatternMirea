package ru.mirea.task6.abstract_factory;

public class TestAbstractFactory {

    public static void main(String[] args) {
        AbstractCarFactory factory = new MercedesFactory();
        factory.createCoupe().getCarInfo();
        factory.createSedan().getCarInfo();
        factory = new NissanFactory();
        factory.createSedan().getCarInfo();
        factory.createCoupe().getCarInfo();
    }
}

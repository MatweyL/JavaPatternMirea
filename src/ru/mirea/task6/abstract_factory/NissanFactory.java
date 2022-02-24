package ru.mirea.task6.abstract_factory;

public class NissanFactory extends AbstractCarFactory{
    @Override
    public Sedan createSedan() {
        return new NissanSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new NissanCoupe();
    }
}

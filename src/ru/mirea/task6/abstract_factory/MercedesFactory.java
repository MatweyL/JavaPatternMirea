package ru.mirea.task6.abstract_factory;

public class MercedesFactory extends AbstractCarFactory{
    @Override
    public Sedan createSedan() {
        return new MercedesSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new MercedesCoupe();
    }
}

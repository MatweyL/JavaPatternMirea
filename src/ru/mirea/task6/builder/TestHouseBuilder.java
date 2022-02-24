package ru.mirea.task6.builder;

public class TestHouseBuilder {

    public static void main(String[] args) {
        HouseDirector standardHouseDirector = new HouseDirector(new StandardHouseBuilder());
        HouseDirector mediumHouseDirector = new HouseDirector(new MediumHouseBuilder());
        HouseDirector eliteHouseDirector = new HouseDirector(new EliteHouseBuilder());
        System.out.println(standardHouseDirector.manufactureHouse());
        System.out.println(mediumHouseDirector.manufactureHouse());
        System.out.println(eliteHouseDirector.manufactureHouse());
    }
}

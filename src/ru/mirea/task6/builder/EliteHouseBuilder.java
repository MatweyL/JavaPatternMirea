package ru.mirea.task6.builder;

public class EliteHouseBuilder implements HouseBuilder{

    private int numberOfRooms;
    private int numberOfFloors;
    private String houseMaterial;
    private String houseColor;
    private boolean hasPool;
    private boolean hasGarden;
    private boolean hasGarage;

    @Override
    public HouseBuilder setRooms() {
        this.numberOfRooms = 18;
        return this;
    }

    @Override
    public HouseBuilder setFloors() {
        this.numberOfFloors = 3;
        return this;
    }

    @Override
    public HouseBuilder setMaterial() {
        this.houseMaterial = "Кирпич";
        return this;
    }

    @Override
    public HouseBuilder setColor() {
        this.houseColor = "Оранжевый";
        return this;
    }

    @Override
    public HouseBuilder setPool() {
        this.hasPool = true;
        return this;
    }

    @Override
    public HouseBuilder setGarden() {
        this.hasGarden = true;
        return this;
    }

    @Override
    public HouseBuilder setGarage() {
        this.hasGarage = true;
        return this;
    }

    @Override
    public House build() {
        House house = new House(numberOfRooms, numberOfFloors, houseMaterial, houseColor, hasPool, hasGarden, hasGarage);
        return house;
    }
}

package ru.mirea.task6.builder;

public class HouseDirector {

    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("House can't be built without House Builder!");
        }
    }

    public House manufactureHouse() {
        return builder.setMaterial().setFloors().setRooms().setGarage().setGarden().setPool().setColor().build();
    }
}

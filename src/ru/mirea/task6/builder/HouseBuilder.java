package ru.mirea.task6.builder;

public interface HouseBuilder {

    HouseBuilder setRooms();
    HouseBuilder setFloors();
    HouseBuilder setMaterial();
    HouseBuilder setColor();
    HouseBuilder setPool();
    HouseBuilder setGarden();
    HouseBuilder setGarage();

    House build();
}

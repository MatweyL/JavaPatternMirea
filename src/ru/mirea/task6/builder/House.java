package ru.mirea.task6.builder;

public class House {
    private int numberOfRooms;
    private int numberOfFloors;
    private String houseMaterial;
    private String houseColor;
    private boolean hasPool;
    private boolean hasGarden;
    private boolean hasGarage;

    public House() {}

    public House(int numberOfRooms, int numberOfFloors, String houseMaterial, String houseColor, boolean hasPool, boolean hasGarden, boolean hasGarage) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfFloors = numberOfFloors;
        this.houseMaterial = houseMaterial;
        this.houseColor = houseColor;
        this.hasPool = hasPool;
        this.hasGarden = hasGarden;
        this.hasGarage = hasGarage;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getHouseMaterial() {
        return houseMaterial;
    }

    public void setHouseMaterial(String houseMaterial) {
        this.houseMaterial = houseMaterial;
    }

    public String getHouseColor() {
        return houseColor;
    }

    public void setHouseColor(String houseColor) {
        this.houseColor = houseColor;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    @Override
    public String toString() {
        return "House{" +
                "numberOfRooms=" + numberOfRooms +
                ", numberOfFloors=" + numberOfFloors +
                ", houseMaterial='" + houseMaterial + '\'' +
                ", houseColor='" + houseColor + '\'' +
                ", hasPool=" + hasPool +
                ", hasGarden=" + hasGarden +
                ", hasGarage=" + hasGarage +
                '}';
    }
}

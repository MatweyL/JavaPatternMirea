package ru.mirea.task6.prototype;

public abstract class Tree{
    private int cost;

    public Tree(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract Tree copy();

    @Override
    public String toString() {
        return "Tree{" +
                "cost=" + cost +
                '}';
    }
}

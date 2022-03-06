package ru.mirea.task6.prototype;

public class PlasticTree extends Tree{

    public PlasticTree(int cost) {
        super(cost);
    }

    @Override
    public Tree copy() {
        PlasticTree plasticTree = new PlasticTree(this.getCost());
        return plasticTree;
    }
}

package ru.mirea.task6.prototype;

public class NaturalTree extends Tree {

    public NaturalTree(int cost) {
        super(cost);
    }

    @Override
    public Tree copy() {
        NaturalTree naturalTree = new NaturalTree(this.getCost());
        return naturalTree;
    }
}

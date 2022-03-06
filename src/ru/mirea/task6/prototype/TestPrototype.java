package ru.mirea.task6.prototype;

public class TestPrototype {

    public static void main(String[] args) {
        Tree plasticTree = new PlasticTree(100);
        Tree newPlasticTree = plasticTree.copy();

        Tree naturalTree = new NaturalTree(200);
        Tree newNaturalTree = naturalTree.copy();

        System.out.println(plasticTree);
        System.out.println(newPlasticTree);
        System.out.println(naturalTree);
        System.out.println(newNaturalTree);
    }

}

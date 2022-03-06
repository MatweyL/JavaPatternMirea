package ru.mirea.task7.composite.leaf;

public class FileTXT extends FileSystemObject {

    private final String extension = ".txt";

    public FileTXT(String name) {
        super(name);
    }

    @Override
    public void printName(int indent) {
        System.out.println(getIndent(indent) + name + extension);
    }
}

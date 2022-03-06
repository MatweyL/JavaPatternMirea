package ru.mirea.task7.composite.leaf;

public class ImageJPG extends FileSystemObject {

    private final String extension = ".jpg";

    public ImageJPG(String name) {
        super(name);
    }

    @Override
    public void printName(int indent) {
        System.out.println(getIndent(indent) + name + extension);
    }
}

package ru.mirea.task7.composite.leaf;

public class FileDOCX extends FileSystemObject {

    private final String extension = ".docx";

    public FileDOCX(String name) {
        super(name);
    }

    @Override
    public void printName(int indent) {
        System.out.println(getIndent(indent) + name + extension);
    }
}

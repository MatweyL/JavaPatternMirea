package ru.mirea.task7.composite.leaf;

public abstract class FileSystemObject {

    protected final String name;

    public FileSystemObject(String name) {
        this.name = name;
    }

    protected String getIndent(int indent) {
        StringBuilder indentString = new StringBuilder();
        indentString.append("-".repeat(Math.max(0, indent)));
        return indentString.toString();
    }

    public abstract void printName(int indent);

}

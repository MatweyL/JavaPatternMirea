package ru.mirea.task7.composite.composite;

import ru.mirea.task7.composite.leaf.FileSystemObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Folder extends FileSystemObject {

    private ArrayList<FileSystemObject> fileSystemObjects = new ArrayList<>();

    private final String extension = "";

    public Folder(String name) {
        super(name);
    }

    @Override
    public void printName(int indent) {
        System.out.println(getIndent(indent) + name + extension);
        for (FileSystemObject fileSystemObject: fileSystemObjects) {
            if (fileSystemObject instanceof Folder) {
                ((Folder) fileSystemObject).printName(indent + 1);
            }
            else {
                System.out.print("-");
                fileSystemObject.printName(indent);
            }

        }
    }

    public void add(FileSystemObject fileSystemObject) {
        fileSystemObjects.add(fileSystemObject);
    }

    public void addAll(FileSystemObject... fileSystemObjectsParameter) {
        fileSystemObjects.addAll(Arrays.asList(fileSystemObjectsParameter));
    }

    public void remove(FileSystemObject fileSystemObject) {
        fileSystemObjects.remove(fileSystemObject);
    }

}

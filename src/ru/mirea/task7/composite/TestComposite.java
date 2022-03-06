package ru.mirea.task7.composite;

import ru.mirea.task7.composite.composite.Folder;
import ru.mirea.task7.composite.leaf.FileDOCX;
import ru.mirea.task7.composite.leaf.FileSystemObject;
import ru.mirea.task7.composite.leaf.FileTXT;
import ru.mirea.task7.composite.leaf.ImageJPG;

public class TestComposite {

    public static void main(String[] args) {
        FileSystemObject o1 = new FileTXT("test");
        FileSystemObject o2 = new FileTXT("data");
        FileSystemObject o3 = new FileTXT("scripts");
        FileSystemObject o4 = new FileTXT("temp");
        FileSystemObject o5 = new FileTXT("log");

        FileSystemObject o6 = new FileDOCX("report");
        FileSystemObject o7 = new FileDOCX("task");
        FileSystemObject o8 = new FileDOCX("requirements");

        FileSystemObject o9 = new ImageJPG("cat");
        FileSystemObject o10 = new ImageJPG("dog");
        FileSystemObject o11 = new ImageJPG("diagram");
        FileSystemObject o12 = new ImageJPG("IMG_O0001_2022_03_06");
        FileSystemObject o13 = new ImageJPG("IMG_O0002_2022_03_06");
        FileSystemObject o14 = new ImageJPG("IMG_O0003_2022_03_06");
        FileSystemObject o15 = new ImageJPG("IMG_O0004_2022_03_06");

        Folder f1 = new Folder("temp_data");
        Folder f2 = new Folder("task");
        Folder f3 = new Folder("project");
        Folder f4 = new Folder("work");
        Folder f5 = new Folder("media");
        Folder f6 = new Folder("images");
        Folder rootFolder = new Folder("user");

        rootFolder.addAll(f5, f4);//user
        f5.add(f6);//user/media
        f4.add(f3);//user/work/project
        f3.addAll(f1, f2);

        f1.addAll(o4, o5);
        f2.addAll(o1, o2, o3, o7);
        f3.addAll(o6, o8);

        f6.addAll(o9, o10, o11, o12, o13, o14, o15);

        rootFolder.printName(0);
    }
}

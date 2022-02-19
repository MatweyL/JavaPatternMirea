package ru.mirea.task5;

import java.util.Scanner;

public class ScannerSingleton1 {
    //Synchronized Accessor
    //Низкая производительность в многопоточной среде
    private static Scanner scanner;

    private ScannerSingleton1() {}

    public static synchronized Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

}

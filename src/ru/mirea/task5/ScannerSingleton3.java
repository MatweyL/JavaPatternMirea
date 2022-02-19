package ru.mirea.task5;

import java.util.Scanner;

public class ScannerSingleton3 {
    //Class Holder Singleton
    private ScannerSingleton3() {}

    private static class ScannerSingleton3Holder {
        public final static Scanner scanner = new Scanner(System.in);
    }

    public static Scanner getInstance() {
        return ScannerSingleton3Holder.scanner;
    }

}

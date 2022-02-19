package ru.mirea.task5;

import java.util.Scanner;

public class TestSingletons {

    public static void main(String[] args) {
        Scanner scanner1_1 = ScannerSingleton1.getInstance();
        Scanner scanner1_2 = ScannerSingleton1.getInstance();
        System.out.println(scanner1_1.equals(scanner1_2));

        Scanner scanner2_1 = ScannerSingleton2.getInstance();
        Scanner scanner2_2 = ScannerSingleton2.getInstance();
        System.out.println(scanner2_1.equals(scanner2_2));


        Scanner scanner3_1 = ScannerSingleton3.getInstance();
        Scanner scanner3_2 = ScannerSingleton3.getInstance();
        System.out.println(scanner3_1.equals(scanner3_2));

    }
}

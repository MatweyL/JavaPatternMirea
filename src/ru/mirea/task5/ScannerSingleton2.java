package ru.mirea.task5;

import java.util.Scanner;

public class ScannerSingleton2 {
    //Double Checked Locking & volatile
    //Плюсы:
    //Ленивая инициализация
    //Потокобезопасность
    //Высокая производительность в многопоточной среде
    //Минусы:
    //Не поддерживается на версиях Java ниже 1.5 (в версии 1.5 исправили работу ключевого слова volatile)
    private static volatile Scanner scanner;

    private ScannerSingleton2() {}

    public static Scanner getInstance() {
        Scanner localInstance = scanner;
        if (localInstance == null) {
            synchronized (ScannerSingleton2.class) {
                localInstance = scanner;
                if (localInstance == null) {
                    scanner = localInstance = new Scanner(System.in);
                }
            }
        }
        return localInstance;
    }

}

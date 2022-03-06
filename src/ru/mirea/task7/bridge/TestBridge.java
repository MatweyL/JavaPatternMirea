package ru.mirea.task7.bridge;

import ru.mirea.task7.bridge.abstraction.ComputerOS;
import ru.mirea.task7.bridge.abstraction.LinuxOS;
import ru.mirea.task7.bridge.abstraction.WindowsOS;
import ru.mirea.task7.bridge.implementation.FarCry3;
import ru.mirea.task7.bridge.implementation.Game;
import ru.mirea.task7.bridge.implementation.HalfLife2;

public class TestBridge {

    public static void main(String[] args) {
        Game hl2 = new HalfLife2();
        Game fc3 = new FarCry3();

        ComputerOS linux = new LinuxOS(hl2);
        ComputerOS windows = new WindowsOS(fc3);

        linux.installGame();
        linux.fixInstallationErrors();
        linux.runGame();

        System.out.println();

        windows.installGame();
        windows.fixInstallationErrors();
        windows.runGame();
    }

}

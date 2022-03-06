package ru.mirea.task7.bridge.abstraction;

import ru.mirea.task7.bridge.implementation.Game;

public class WindowsOS extends ComputerOS {
    public WindowsOS(Game game) {
        super(game);
    }

    @Override
    public void installGame() {
        System.out.println("Installing game on a Windows...");
        game.install();
        System.out.println("Setting mods...");
        game.setMods();
    }

    @Override
    public void fixInstallationErrors() {
        if (game.wasInstallationError()) {
            System.out.println("There is installation error! Windows Defender blocked some exe files!");
            System.out.println("Disabling Windows Defender...");
            game.fixError();
        }
        else {
            System.out.println("The installation game on the Windows was successfully!");
        }
    }

    @Override
    public void runGame() {
        System.out.println("Let's play!");
        game.run();
    }
}

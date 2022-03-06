package ru.mirea.task7.bridge.abstraction;

import ru.mirea.task7.bridge.implementation.Game;

public class LinuxOS extends ComputerOS {
    public LinuxOS(Game game) {
        super(game);
    }

    @Override
    public void installGame() {
        System.out.println("Installing game on a Linux...");
        game.install();
        System.out.println("Setting mods...");
        game.setMods();
    }

    @Override
    public void fixInstallationErrors() {
        if (game.wasInstallationError()) {
            System.out.println("Oh, unknown error...");
            System.out.println("Google the error for one hour...");
            System.out.println("two hour...");
            System.out.println("three hour...");
            System.out.println("Delete and install the game again");
            game.fixError();
        }
        else {
            System.out.println("Installation game on the Linux was successfully!");
        }
    }

    @Override
    public void runGame() {
        if (game.wasErrorFixing()) {
            System.out.println("Ohh, I'm so tired, I don't want to play a game...");
        }
        else {
            System.out.println("Play game on a Linux :D");
            game.run();
        }
    }
}

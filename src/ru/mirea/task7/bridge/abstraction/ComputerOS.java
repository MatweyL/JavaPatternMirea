package ru.mirea.task7.bridge.abstraction;

import ru.mirea.task7.bridge.implementation.Game;

public abstract class ComputerOS {
    protected Game game;

    public ComputerOS(Game game) {
        this.game = game;
    }

    public abstract void installGame();

    public abstract void fixInstallationErrors();

    public abstract void runGame();

}

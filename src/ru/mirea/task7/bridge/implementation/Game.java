package ru.mirea.task7.bridge.implementation;

public interface Game {

    void install();

    void setMods();

    boolean wasInstallationError();

    void fixError();

    boolean wasErrorFixing();

    void run();

}

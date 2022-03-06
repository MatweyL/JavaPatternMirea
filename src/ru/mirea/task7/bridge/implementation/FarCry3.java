package ru.mirea.task7.bridge.implementation;

public class FarCry3 implements Game{

    private boolean error;
    private boolean wasError = false;

    @Override
    public void install() {
        System.out.println("Install Half-Life 2...");
        error = Math.random() * 10 > 5;
    }

    @Override
    public void setMods() {
        System.out.println("Skins mod is successfully installed in Far Cry 3!");
    }

    @Override
    public boolean wasInstallationError() {
        return error;
    }

    @Override
    public void fixError() {
        System.out.println("The error was fixed!");
        error = false;
        wasError = true;
    }

    @Override
    public boolean wasErrorFixing() {
        return wasError;
    }

    @Override
    public void run() {
        System.out.println("So good! You are playing in Far Cry 3");
    }

}

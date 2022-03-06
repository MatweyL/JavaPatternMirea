package ru.mirea.task7.bridge.implementation;

public class HalfLife2 implements Game{

    private boolean error;
    private boolean wasError = false;

    @Override
    public void install() {
        System.out.println("Install Half-Life 2...");
        error = Math.random() * 10 > 5;
    }

    @Override
    public void setMods() {
        System.out.println("Guns mod is successfully installed in Half-Life 2 configuration!");
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
        System.out.println("Cool! You are playing Half-Life 2!");
    }


}

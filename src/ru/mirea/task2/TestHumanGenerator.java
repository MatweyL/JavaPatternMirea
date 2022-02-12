package ru.mirea.task2;

public class TestHumanGenerator {
    public static void main(String[] args) {
        Human[] humans = HumanGenerator.generateHumans();
        HumanGenerator.doActions(humans);
    }
}

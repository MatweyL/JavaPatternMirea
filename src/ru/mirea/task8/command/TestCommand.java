package ru.mirea.task8.command;

public class TestCommand {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.plus(5);
        calculator.printResult();
        calculator.undo();
        calculator.printResult();
        calculator.minus(10);
        calculator.printResult();
        calculator.multiply(97);
        calculator.printResult();
        calculator.divide(14);
        calculator.printResult();
        calculator.undo();
        calculator.printResult();
        calculator.undo();
        calculator.printResult();
        calculator.plus(100);
        calculator.printResult();
    }
}

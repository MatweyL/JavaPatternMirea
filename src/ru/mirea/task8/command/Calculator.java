package ru.mirea.task8.command;

import ru.mirea.task8.command.calculator_commands.*;

public class Calculator {

    private final ArithmeticUnit arithmeticUnit;
    private final ControlUnit controlUnit;
    private double currentValue = 0;

    public Calculator() {
        arithmeticUnit = new ArithmeticUnit();
        controlUnit = new ControlUnit();
    }

    private double runCommand(Command command) {
        controlUnit.saveCommand(command);
        controlUnit.executeCommand();
        currentValue = arithmeticUnit.getRegister();
        return currentValue;
    }

    public double plus(double operand) {
        return runCommand(new AddCommand(arithmeticUnit, operand));
    }

    public double minus(double operand) {
        return runCommand(new SubCommand(arithmeticUnit, operand));
    }

    public double multiply(double operand) {
        return runCommand(new MulCommand(arithmeticUnit, operand));
    }

    public double divide(double operand) {
        return runCommand(new DivCommand(arithmeticUnit, operand));
    }

    public double undo() {
        controlUnit.undo();
        currentValue = arithmeticUnit.getRegister();
        return currentValue;
    }

    public void printResult() {
        System.out.println("CURRENT VALUE: " + currentValue);
    }


}

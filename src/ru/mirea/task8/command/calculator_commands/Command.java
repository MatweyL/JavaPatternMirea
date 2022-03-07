package ru.mirea.task8.command.calculator_commands;

import ru.mirea.task8.command.ArithmeticUnit;
public abstract class Command {

    protected ArithmeticUnit arithmeticUnit;
    protected double operand;

    public Command(ArithmeticUnit arithmeticUnit, double operand) {
        this.arithmeticUnit = arithmeticUnit;
        this.operand = operand;
    }

    public abstract void execute();

    public abstract void undo();

}

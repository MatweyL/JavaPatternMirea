package ru.mirea.task8.command.calculator_commands;

import ru.mirea.task8.command.ArithmeticUnit;

public class SubCommand extends Command {

    public SubCommand(ArithmeticUnit arithmeticUnit, double operand) {
        super(arithmeticUnit, operand);
    }

    @Override
    public void execute() {
        arithmeticUnit.run(operand, '-');
    }

    @Override
    public void undo() {
        arithmeticUnit.run(operand, '+');
    }
}

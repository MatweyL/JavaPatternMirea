package ru.mirea.task8.command;

import ru.mirea.task8.command.calculator_commands.Command;

import java.util.ArrayList;
import java.util.Stack;

public class ControlUnit {

    private Stack<Command> commandsHistory = new Stack<>();

    public void saveCommand(Command command) {
        commandsHistory.add(command);
    }

    public void executeCommand() {
        commandsHistory.peek().execute();
    }

    public void undo() {
        if (!commandsHistory.isEmpty()) {
            commandsHistory.pop().undo();
        }

    }

}

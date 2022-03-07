package ru.mirea.task8.command;

//Receiver object
public class ArithmeticUnit {

    private double register = 0;

    public void run(double operand, char operation) {
        switch (operation) {
            case '+' -> register += operand;
            case '-' -> register -= operand;
            case '*' -> register *= operand;
            case '/' -> register /= operand;
        }
    }

    public double getRegister() {
        return register;
    }
}

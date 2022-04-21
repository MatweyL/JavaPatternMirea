package ru.mirea.task8.command;

//Receiver object
public class ArithmeticUnit {

    private double register = 0;

    public void run(double operand, char operation) {
        switch (operation) {
            case '+':
                register += operand;
                break;
            case '-':
                register -= operand;
                break;
            case '*':
                register *= operand;
                break;
            case '/':
                register /= operand;
                break;
        }
    }

    public double getRegister() {
        return register;
    }
}

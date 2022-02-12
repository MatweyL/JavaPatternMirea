package ru.mirea.task1;

import java.util.function.Function;

public class TestStringArrayFunction {
    public static void main(String[] args) {
        String[] strings = new String[] {"abc", "def", "ghi"};
        for (String string: strings) {
            System.out.println(string);
        }
        Function<String[], String[]> stringArrayReverser = stringsArray -> {
            String[] reversedStrings = new String[stringsArray.length];
            for (int i = 0; i < stringsArray.length; i++) {
                reversedStrings[i] = new StringBuilder(stringsArray[i]).reverse().toString();
            }
            return reversedStrings;
        };
        for (String string:
             stringArrayReverser.apply(strings)) {
            System.out.println(string);
        }
    }
}

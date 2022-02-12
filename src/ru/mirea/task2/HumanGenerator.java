package ru.mirea.task2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class HumanGenerator {

    final static String[] names = new String[] {"Bob", "Mark", "Anton", "Bill", "John", "Lisa", "Nastya", "Katya"};
    final static String[] surnames = new String[] {"Kovalev", "Sinitsin", "Stoluarov", "Mishkin", "Zubachev", "Nagorny", "Delovoy", "Veselie", "Ivanov"};


    public static Human[] generateHumans() {
        int generatedHumansLength = (int) Math.round(10 * Math.random() + 5);
        Human[] generatedHumans = new Human[generatedHumansLength];
        for (int i = 0; i < generatedHumansLength; i++) {
            int age =  (int) Math.round(20 * Math.random() + 15);
            int randomNameIndex = (int) Math.floor(names.length * Math.random());
            int randomSurnameIndex = (int) Math.floor(surnames.length * Math.random());
            generatedHumans[i] = new Human(age, names[randomNameIndex], surnames[randomSurnameIndex], LocalDate.of(2022 - age,
                    (int) Math.floor(11 * Math.random() + 1), (int) Math.floor(28 * Math.random()) + 1), (int) Math.round(50 + 40 * Math.random()));
        }
        return generatedHumans;
    }
    //MVC
    public static void doActions(Human[] humans) {
        System.out.println("===STREAM===");
        Stream<Human> humansStream = Arrays.stream(humans);
        humansStream.sorted((o1, o2) -> - (o1.getWeight() - o2.getWeight())).forEach(System.out::println);
        System.out.println("===STREAM===");
        humansStream = Arrays.stream(humans);
        humansStream.filter((h) -> !(h.getLastName().equals("Ivanov"))).forEach(System.out::println);
        System.out.println("===STREAM===");
        humansStream = Arrays.stream(humans);
        humansStream.sorted(Comparator.comparingInt(Human::getAge)).forEach(System.out::println);
        System.out.println("===STREAM===");
        humansStream = Arrays.stream(humans);
        Optional<Integer> multiplicationResult = humansStream.map(Human::getAge).reduce((o1, o2) -> o1 * o2);
        System.out.println(multiplicationResult.get());
    }

}

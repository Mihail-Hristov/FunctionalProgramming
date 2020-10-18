import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split(", ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        String condition = scanner.nextLine();
        Integer ageLimit = Integer.parseInt(scanner.nextLine());

        String formatForPrinting = scanner.nextLine();

        Predicate<Person> printCriteria = createCheck(condition, ageLimit);

        Function<Person, String> printFormat = formattedPrint(formatForPrinting);

        people.stream()
                .filter(printCriteria)
                .forEach(p -> System.out.println(printFormat.apply(p)));

    }

    private static Predicate<Person> createCheck(String condition, Integer ageLimit) {
        Predicate<Person> printCriteria = null;

        switch (condition) {
            case "younger":
                printCriteria = x -> x.age <= ageLimit;
                break;
            case "older":
                printCriteria = x -> x.age >= ageLimit;

                break;
        }

        return printCriteria;
    }

    private static Function<Person, String> formattedPrint(String formatForPrinting) {
        Function<Person, String> printFormat = null;

        String[] tokens = formatForPrinting.split("\\s+");
        if (tokens.length > 1) {
            printFormat = p -> p.name + " - " + p.age;
        }else {
            switch (tokens[0]) {
                case "name":
                    printFormat = p -> p.name;

                    break;
                case "age":
                    printFormat = p -> String.valueOf(p.age);

                    break;
            }
        }
        return printFormat;
    }


    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

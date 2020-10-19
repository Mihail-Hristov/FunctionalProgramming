import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maximumLength = Integer.parseInt(scanner.nextLine());

        Predicate<String> shorterThanN = n -> n.length() <= maximumLength;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(shorterThanN)
                .forEach(System.out::println);

    }
}

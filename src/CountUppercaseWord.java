import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startWithUppercase = w -> Character.isUpperCase(w.charAt(0));

        List<String> text = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startWithUppercase)
                .collect(Collectors.toList());

        System.out.println(text.size());
        System.out.println(text.stream()
        .collect(Collectors.joining(System.lineSeparator())));

        /*String[] inputtedText = scanner.nextLine().split("\\s+");

        List<String> wordWithUppercaseLetter = new ArrayList<>();

        Predicate<String> startWithUppercase = w -> w.charAt(0) > 64 && w.charAt(0) < 91;

        for (String word : inputtedText) {
            if (startWithUppercase.test(word)){
                wordWithUppercaseLetter.add(word);
            }
        }

        System.out.println(wordWithUppercaseLetter.size());
        wordWithUppercaseLetter.stream()
                .forEach(w -> System.out.println(w));*/

    }
}

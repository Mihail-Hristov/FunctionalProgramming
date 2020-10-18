import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        String firstOutput = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));


        System.out.println(firstOutput);

        numbers.sort((a, b) -> a.compareTo(b));

        String secondOutput = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(secondOutput);
    }
}

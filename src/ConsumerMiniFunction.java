import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConsumerMiniFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Function<Integer[], Integer> findSmallestNumber = n -> Arrays.stream(n)
                .min(Integer::compareTo)
                .orElse(null);

        System.out.println(findSmallestNumber.apply(input));

    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            Function<Integer, Integer> appliedCommand = configured(command);

            for (int i = 0; i < numbers.size(); i++) {
                numbers.set(i, appliedCommand.apply(numbers.get(i)));
            }

            command = scanner.nextLine();
        }

    }

    private static Function<Integer, Integer> configured(String command) {
        Function<Integer, Integer> result = null;

        switch (command) {
            case "add":
                result = n -> n += 1;

                break;
            case "multiply":
                result = n -> n *= 2;

                break;
            case "subtract":
                result = n -> n -= 1;

                break;
            case "print":
                result = n -> {
                    System.out.print(n + " ");

                    return n;
                };

                break;
        }

        return result;
    }
}

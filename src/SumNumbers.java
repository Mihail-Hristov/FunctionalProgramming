import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();


        Function<int[], String> getCount =
                arr -> String.format("Count = %d", arr.length);

        Function<int[], String> gerSum =
                arr -> String.format("Sum = %d", Arrays.stream(arr).sum());

        System.out.println(getCount.apply(numbers));
        System.out.println(gerSum.apply(numbers));

        /*String[] input = scanner.nextLine().split(", ");

        Function<String, Integer> parseFunction = Integer::parseInt;

        int sum = 0;

        for (String item : input) {
            sum += parseFunction.apply(item);
        }

        System.out.println(String.format("Count = %d", input.length));
        System.out.println(String.format("Sum = %d", sum));*/
    }
}

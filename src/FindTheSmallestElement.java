import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> indexOfSmallestNumber = arr -> {
            int index = 0;
            int smallNumber = Integer.MAX_VALUE;

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) <= smallNumber) {
                    smallNumber = arr.get(i);
                    index = i;
                }
            }
            return index;
        };

        System.out.println(indexOfSmallestNumber.apply(numbers));

    }
}

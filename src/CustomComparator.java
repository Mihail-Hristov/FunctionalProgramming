import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());


        Collections.sort(numbers);

        Function<List<Integer>, List<Integer>> orderByType = arr -> {
            List<Integer> result = new ArrayList<>();
            Predicate<Integer> even = n -> n % 2 == 0;
            Predicate<Integer> odd = n -> n % 2 != 0;
            for (int i = 0; i < arr.size(); i++) {
                if (even.test(arr.get(i))) {
                    result.add(arr.get(i));
                }
            }

            for (int i = 0; i < arr.size(); i++) {
                if (odd.test(arr.get(i))) {
                    result.add(arr.get(i));
                }
            }

            return result;
        };

        List<Integer> result = orderByType.apply(numbers);

        for (Integer item : result) {
            System.out.print(item + " ");
        }



    }
}

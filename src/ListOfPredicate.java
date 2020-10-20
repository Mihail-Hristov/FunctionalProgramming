import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rangeLimit = Integer.parseInt(scanner.nextLine());

        int[] divisibleBy = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        BiPredicate<Integer, int[]> isDivisible = (number, arr) -> {
            boolean result = false;

            for (int i = 0; i < arr.length; i++) {
                if (number % arr[i] == 0) {
                    result = true;
                }else {
                    result = false;
                    break;
                }
            }
            return result;
        };

        for (int i = 1; i <= rangeLimit; i++) {
            if (isDivisible.test(i, divisibleBy)) {
                System.out.print(i + " ");
            }
        }
    }
}

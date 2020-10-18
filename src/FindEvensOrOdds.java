import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int startNumber = Integer.parseInt(tokens[0]);
        int endNumber = Integer.parseInt(tokens[1]);

        String searchingType = scanner.nextLine();

        Predicate<Integer> filteredByType = configureByInput(searchingType);

        for (int i = startNumber; i <= endNumber; i++) {
            if (filteredByType.test(i)) {
                System.out.print(i + " ");
            }
        }

    }

    private static Predicate<Integer> configureByInput(String type) {
        Predicate<Integer> result = null;
        switch (type) {
            case "even":
                result = n -> n % 2 == 0;

                break;
            case "odd":
                result = n -> n % 2 != 0;

                break;
        }
        return result;
    }
}

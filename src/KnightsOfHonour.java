import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> addSirToText = w -> System.out.println("Sir " + w);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(addSirToText);
    }
}

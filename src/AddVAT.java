import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Double> addVAT = d -> System.out.println(String.format("%.2f",(d * 1.2)));

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");

        for (Double number : numbers) {
            addVAT.accept(number);
        }



    }
}

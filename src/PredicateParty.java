import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        BiPredicate<String, String> startWith = (name, search) -> {
            boolean result = false;

            for (int i = 0; i < search.length(); i++) {
                if (name.charAt(i) == search.charAt(i)) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
            return result;
        };

        BiPredicate<String, String> endWith = (name, search) -> {
            boolean result = false;
            int index = 0;

            for (int i = name.length() - search.length(); i < name.length(); i++) {
                if (name.charAt(i) == search.charAt(index)) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
                index++;
            }
            return result;
        };

        BiPredicate<String, Integer> equalsToLength = (name, length) -> {
            boolean result = false;

            if (name.length() == length) {
                result = true;
            }
            return result;
        };

        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String criteria = tokens[1];

            if (command.equals("Remove"))
                switch (criteria) {
                    case "StartsWith":
                        String startString = tokens[2];
                        for (int i = 0; i < names.size(); i++) {
                            if (startWith.test(names.get(i), startString)) {
                                names.remove(i);
                                i--;
                            }
                        }
                        break;
                    case "Length":
                        int length = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < names.size(); i++) {
                            if (equalsToLength.test(names.get(i), length)) {
                                names.remove(i);
                                i--;
                            }
                        }

                        break;
                    case "EndsWith":
                        String endString = tokens[2];
                        for (int i = 0; i < names.size(); i++) {
                            if (endWith.test(names.get(i), endString)) {
                                names.remove(i);
                                i--;
                            }
                        }

                        break;
                }
            else if (command.equals("Double")) {
                switch (criteria) {
                    case "StartsWith":
                        String startString = tokens[2];
                        for (int i = 0; i < names.size(); i++) {
                            if (startWith.test(names.get(i), startString)) {
                                names.add(0, names.get(i));
                                i ++;
                            }
                        }
                        break;
                    case "Length":
                        int length = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < names.size(); i++) {
                            if (equalsToLength.test(names.get(i), length)) {
                                names.add(0, names.get(i));
                                i ++;
                            }
                        }

                        break;
                    case "EndsWith":
                        String endString = tokens[2];
                        for (int i = 0; i < names.size(); i++) {
                            if (endWith.test(names.get(i), endString)) {
                                names.add(0, names.get(i));
                                i ++;
                            }
                        }

                        break;
                }
            }
            input = scanner.nextLine();
        }


        if (names.size() > 0) {
            Collections.sort(names);
            String output = names.stream().collect(Collectors.joining(", "));
            System.out.print(output);
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}

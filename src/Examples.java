import java.util.Arrays;
import java.util.List;

public class Examples {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Al", "Jean", "Bob", "Stacy", "Rob", "Elvis", "Stan", "Steve");

        nameList.stream()
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

    }
}

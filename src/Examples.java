import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Examples {
    public static void main(String[] args) {
        // For regular array, use Stream.of(array name) to turn it into a Stream
        String [] nameArr =  new String []{"Al", "Jean", "Bob", "Stacy", "Rob", "Elvis", "Stan", "Steve"};
        Stream.of(nameArr)
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        // A Collection has built in .stream() method
        List<String> nameList = Arrays.asList("Al", "Jean", "Bob", "Stacy", "Rob", "Elvis", "Stan", "Steve");

        nameList.stream()
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

    }
}

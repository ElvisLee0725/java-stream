import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // With Java 8, Collection interface has two methods to generate a Stream.
        //stream() − Returns a sequential stream considering collection as its source.
        //parallelStream() − Returns a parallel Stream considering collection as its source.

        IntStream
                .range(1, 10)   // end is exclusive
                .skip(3)    // Skip the first n numbers
                .forEach(System.out::println);

        // Method reference or double colon operator can be used to refer:
        // a static method,
        // an instance method, or
        // a constructor.

        System.out.println();

        System.out.println(
                IntStream
                        .range(1, 4)
                        .sum()  // Sum up all numbers in stream
        );

        Stream.of("Elvis", "Ana", "Peter")
                .sorted()
                .findFirst()        // Get the first item
                .ifPresent(System.out::println);    // If exist, then...

        String [] names = {"Al", "Jean", "Bob", "Stacy", "Rob", "Elvis", "Stan", "Steve"};
        Arrays.stream(names)
                .filter(name -> name.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3, 4})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        List<String> people = Arrays.asList("Al", "Jean", "Bob", "Stacy", "Ann", "Rob", "Elvis", "Stan", "Steve", "Alex");

        people.stream()
                .map(String::toLowerCase)
                .filter(name -> name.startsWith("a"))
                .forEach(System.out::println);

        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println(total);

        // Get the summary of all items in the stream
        IntSummaryStatistics summary = IntStream.of(1, 4, 6, 7, 8)
                .summaryStatistics();

        System.out.println(summary);

        // Collectors are used to combine the result of processing on the elements of a stream.
        // Collectors can be used to return a list or a string.
        List<String> strList = Arrays.asList("asdf", "", "", "dfd", "", "eeds");
        List<String> resList = strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(resList);

        String resStr = strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(", "));
        System.out.println(resStr);

    }
}

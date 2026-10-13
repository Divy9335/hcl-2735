package Day6.Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsClass {
    static void main() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);

        ls.stream().filter((num)->num%2==0).forEach(System.out::println);
        List<Integer> newLs = ls.stream().filter((num)->num%2==0).toList();
        System.out.println(newLs);
    }
}

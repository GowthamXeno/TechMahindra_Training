
import java.util.*;
import java.util.stream.Stream;

public class LinkedHashSetThread extends Thread{
    public void run() {
        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("A");
        lhs.add("B");
        lhs.add("ABCD");
        lhs.add("SP");
        lhs.add("AIA");
        lhs.add("MDA");
        lhs.add("B");
        System.out.println("HashSet Size: " + lhs.size());
        System.out.println("Elements in HashSet: " + lhs);
        System.out.print("Using iterator : ");
        Iterator<String> iterator = lhs.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
        System.out.print("Using enhanced for loop : ");
        for (String element : lhs)
            System.out.print(element + " ");
                    Stream<String> LinkedHashSetStream = lhs.stream().filter(e -> e.length() > 5);
        System.out.println("The String Having Greater than length 5 : ");
        LinkedHashSetStream.forEach(e -> System.out.println(e));
    }
}

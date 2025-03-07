
import java.util.*;
import java.util.stream.Stream;

class TreeSetThread extends Thread {
    public void run() {
        Set<Float> ts = new TreeSet<>();
        ts.add(20.3f);
        ts.add(12f);
        ts.add(42.4f);
        ts.add(72.3f);
        ts.add(8.3f);
        ts.add(4.3f);
        ts.add(22.3f);
        ts.add(10.f);
        System.out.println("HashSet Size: " + ts.size());
        System.out.println("Elements in HashSet: " + ts);
        System.out.print("Using iterator : ");
        Iterator<Float> iterator = ts.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
        // System.out.print("Using enhanced for loop : ");
        // for (Float element : ts)
        // System.out.print(element + " ");
        System.out.println("\nHashSet after removing element : " + ts);

        Stream<Float> StreamTreeSet = ts.stream().filter(e -> e > 20);
        System.out.println("After Filtering the TreeSet : ");
        StreamTreeSet.forEach(e -> System.out.println(e));

    }
}

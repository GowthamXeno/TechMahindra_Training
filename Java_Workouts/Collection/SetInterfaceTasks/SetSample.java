import java.util.*;
import java.util.stream.Stream;

public class SetSample {
    public static void main(String[] args) {

        TreeSet<Float> ts = new TreeSet<>();
        ts.add(20.3f);
        ts.add(12f);
        ts.add(42.4f);
        ts.add(72.3f);
        ts.add(8.3f);
        ts.add(4.3f);
        ts.add(22.3f);
        ts.add(10.f);
        setSample(ts);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Abi");
        lhs.add("Harish");
        lhs.add("Gowtham");
        lhs.add("XenO");
        lhs.add("Amudesh");
        lhs.add("Arun");
        lhs.add("Gowtham");
        lhs.add("Jeshwant");
        lhs.add("Pugaz");
        setSample(lhs);

        HashSet<Integer> hs = new HashSet<>();
        hs.add(14);
        hs.add(20);
        hs.add(35);
        hs.add(21);
        hs.add(22);
        hs.add(70);
        hs.add(42);
        hs.add(12);
        setSample(hs);

    }

    public static void setSample(HashSet<Integer> hs) {
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        System.out.print("Using enhanced for loop : ");
        for (Integer element : hs)
            System.out.print(element + " ");
        Stream<Integer> StreamHashSet = hs.stream().filter(e -> e % 7 == 0);
        System.out.println("After Filtering the HashSet Number which are Divisible By 7 : ");
        StreamHashSet.forEach(e -> System.out.println(e));
        System.out.println("-------------------------------------------------------------------");
    }

    public static void setSample(LinkedHashSet<String> lhs) {
        System.out.println("HashSet Size: " + lhs.size());
        System.out.println("Elements in HashSet: " + lhs);
        System.out.print("Using iterator : ");
        Iterator<String> iterator = lhs.iterator();
        while (iterator.hasNext())
        System.out.print(iterator.next() + " ");
        System.out.println();
        Stream<String> LinkedHashSetStream = lhs.stream().filter(e -> e.length() > 5);
        System.out.println("The String Having Greater than length 5 : ");
        LinkedHashSetStream.forEach(e -> System.out.println(e));
        System.out.println("-------------------------------------------------------------------");
    }

    public static void setSample(TreeSet<Float> ts) {
        System.out.println("TreeSet Size: " + ts.size());
        System.out.println("Elements in TreeSet: " + ts);
        System.out.print("Using iterator : ");
        Iterator<Float> iterator = ts.iterator();
        while (iterator.hasNext())
        System.out.print(iterator.next() + " ");
        System.out.println();

        Stream<Float> StreamTreeSet = ts.stream().filter(e -> e > 20);
        System.out.println("After Filtering the TreeSet Greater then 20: ");
        StreamTreeSet.forEach(e -> System.out.println(e));
        System.out.println("-------------------------------------------------------------------");
    }
}

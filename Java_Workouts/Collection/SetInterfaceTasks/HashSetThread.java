
import java.util.*;
import java.util.stream.Stream;

public class HashSetThread extends Thread{
    public void run(){
        Set<Integer> hs = new HashSet<>();
        hs.add(12);
        hs.add(20);
        hs.add(32);
        hs.add(2);
        hs.add(22);
        hs.add(62);
        hs.add(4);
        hs.add(15);
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        System.out.print("Using enhanced for loop : ");
        for (Integer element : hs)
            System.out.print(element + " ");
        Stream<Integer> StreamHashSet = hs.stream().filter(e -> e  %7 == 0);
        System.out.println("After Filtering the HashSet Number which are Divisible By 7 : ");
        StreamHashSet.forEach(e -> System.out.println(e));
    }
}

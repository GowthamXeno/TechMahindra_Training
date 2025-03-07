// 14. Write a Java program to iterate a linked list in reverse order.


import java.util.LinkedList;
import java.util.ListIterator;

public class Task14 {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Paris");
        cities.add("London");
        cities.add("Rome");
        cities.add("Berlin");

        System.out.println("Cities in reverse order:");
        ListIterator<String> iterator = cities.listIterator(cities.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}

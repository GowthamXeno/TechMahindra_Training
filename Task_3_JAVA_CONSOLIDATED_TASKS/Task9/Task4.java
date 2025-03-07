// 4. Write a Java program to remove all duplicate elements from a list using streams

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6, 7);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("List without duplicates: " + uniqueNumbers);
    }
}

// 5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.

import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado", "blueberry");
        char targetLetter = 'a';

        long count = words.stream()
                          .filter(word -> word.startsWith(String.valueOf(targetLetter)))
                          .count();

        System.out.println("Number of strings starting with '" + targetLetter + "': " + count);
    }
}


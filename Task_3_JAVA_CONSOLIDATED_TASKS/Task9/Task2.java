// 2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Mahindra", "Benz", "Cherry", "daTE");


        List<String> upperCaseList = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCaseList);


        List<String> lowerCaseList = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("Lowercase: " + lowerCaseList);
    }
}

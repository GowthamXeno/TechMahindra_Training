// 6. Write a Java program to remove the third element from an array list.


import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");
        languages.add("Ruby");

        languages.remove(2); 
        System.out.println("Updated languages list: " + languages);
    }
}

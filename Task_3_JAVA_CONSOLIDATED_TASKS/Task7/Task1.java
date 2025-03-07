// 1. Write a Java program to create an array list, add some colors (strings) and print out the collection.

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("Colors: " + colors);
    }
}

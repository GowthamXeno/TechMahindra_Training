// 18. Write a Java program to insert the specified element at the end of a linked list.


import java.util.LinkedList;

public class Task18 {
    public static void main(String[] args) {
        LinkedList<String> drinks = new LinkedList<>();
        drinks.add("Coffee");
        drinks.add("Tea");

        drinks.addLast("Juice"); 
        System.out.println("Updated drinks list: " + drinks);
    }
}

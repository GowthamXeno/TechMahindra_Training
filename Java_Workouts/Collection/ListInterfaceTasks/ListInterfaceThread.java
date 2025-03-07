package ListInterfaceTasks;
import java.util.*;
class VectorThread extends Thread {
    public void run() {
        List<Integer> list = new Vector<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        // System.out.println("Is list empty? "+list.isEmpty());
        // System.out.println("The given list is:"+list1);
        System.out.println("Number of elements in the Vector: " + list.size());
        // Adding one element
        list.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given Vector is :" + list);
        System.out.println("The number of elements in the vector: " + list.size());
        // Checking for an element
        System.out.println("Is 566 available in the vector:" + list.contains(566));
        System.out.println("The given vector before removing elements is :" + list);

        list.remove(2);// Removing element by its index
        list.remove(3);// Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given vector is :" + list);
        System.out.println("The number of elements in the vector: " + list.size());

    }
}
class StackThread extends Thread {
    public void run() {
        List<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(1);
        stack.add(2);
        stack.add(4);
        stack.add(5);
        // System.out.println("Is stack empty? "+stack.isEmpty());
        // System.out.println("The given stack is:"+stack1);
        System.out.println("Number of elements in the Stack: " + stack.size());
        // Adding one element
        stack.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given Stack is :" + stack);
        System.out.println("The number of elements in the Stack: " + stack.size());
        // Checking for an element
        System.out.println("Is 566 available in the Stack:" + stack.contains(566));
        System.out.println("The given Stack before removing elements is :" + stack);

        stack.remove(2);// Removing element by its index
        stack.remove(3);// Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given Stack is :" + stack);
        System.out.println("The number of elements in the Stack: " + stack.size());

    }
}

class LinkedListThread extends Thread{
    public void run(){
        List<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);

        // System.out.println("Is list empty? "+list.isEmpty());
        // System.out.println("The given list is:"+list1);
        System.out.println("Number of elements in the Linkedlist: " + list.size());
        // Adding one element
        list.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given Linkedlist is :" + list);
        System.out.println("The number of elements in the Linkedlist: " + list.size());
        // Checking for an element
        System.out.println("Is 566 available in the Linkedlist:" + list.contains(566));
        System.out.println("The given list before removing elements is :" + list);

        list.remove(2);// Removing element by its index
        list.remove(3);// Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given Linkedlist is :" + list);
        System.out.println("The number of elements in the Linkedlist: " + list.size());
    }
}
public class ListInterfaceThread{
    public static void main(String[] args) {
        LinkedListThread LLT = new LinkedListThread();
        LLT.start();
        VectorThread VT = new VectorThread();
        VT.start();
        StackThread ST = new StackThread();
        ST.start();
    }
}

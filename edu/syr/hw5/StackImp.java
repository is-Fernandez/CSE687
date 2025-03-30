package edu.syr.hw5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StackImp<E> implements Stack<E> {
    private final List<E> list = new ArrayList<>(); // Adapted list

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        if (list.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if (list.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public List<E> getData() {
        return Collections.unmodifiableList(list);
    }


    // Optional: For testing purposes
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImp<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.size()); // 3
        System.out.println("Top element: " + stack.peek()); // 3

        System.out.println("Popped element: " + stack.pop()); // 3
        System.out.println("Stack size after pop: " + stack.size()); // 2

        System.out.println("Stack contents: " + stack.getData()); // [1, 2]
    }
}

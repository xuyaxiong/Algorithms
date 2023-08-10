package org.example.chapter_1.section_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<Item> implements IStack<Item>, Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    public Node first;
    private int N;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        List<String> strings = Arrays.asList("to", "be", "or", "not", "to", "be");
        for (String s : strings) {
            stack.push(s);
        }

        for (String s : stack) {
            System.out.println(s);
        }
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}



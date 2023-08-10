package org.example.chapter_1.section_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Queue<Item> implements IQueue<Item>, Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;

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
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    @Override
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("to", "be", "or", "not", "to", "be");
        Queue<String> queue = new Queue<>();
        for (String s : strings) {
            queue.enqueue(s);
        }

        queue.dequeue();
        queue.dequeue();

        for (String s : queue) {
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

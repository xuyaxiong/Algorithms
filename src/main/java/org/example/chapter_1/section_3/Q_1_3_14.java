package org.example.chapter_1.section_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.example.chapter_1.section_3.impl.IQueue;

import java.util.Iterator;

public class Q_1_3_14<Item> implements IQueue<Item>, Iterable<Item> {
    private static final int INIT_CAPACITY = 8;

    private Item[] items;
    private int head;
    private int tail;

    public Q_1_3_14() {
        items = (Item[]) new Object[INIT_CAPACITY];
        head = 0;
        tail = -1;
    }

    @Override
    public boolean isEmpty() {
        return tail - head + 1 == 0;
    }

    @Override
    public int size() {
        return tail - head + 1;
    }

    @Override
    public void enqueue(Item item) {
        if (tail + 1 == items.length) {
            resize(items.length * 2);
        }
        items[++tail] = item;
    }

    private void resize(int capacity) {
        Item[] oldItems = items;
        items = (Item[]) new String[capacity];
        for (int i = 0; i < (tail - head + 1); ++i) {
            items[i] = oldItems[head + i];
        }
        tail = tail - head;
        head = 0;
    }

    @Override
    public Item dequeue() {
        if (tail - head + 1 == items.length / 4) {
            resize(items.length / 2);
        }
        return items[head++];
    }

    public static void main(String[] args) {
        Q_1_3_14<String> queue = new Q_1_3_14<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int first = head;
        private int last = tail;

        @Override
        public boolean hasNext() {
            return last - first + 1 > 0;
        }

        @Override
        public Item next() {
            return items[first++];
        }
    }
}

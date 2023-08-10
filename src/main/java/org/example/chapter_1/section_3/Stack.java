package org.example.chapter_1.section_3;

public class Stack<Item> implements IStack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void push(Item item) {

    }


    @Override
    public Item pop() {
        return null;
    }
}



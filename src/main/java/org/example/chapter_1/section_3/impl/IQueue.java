package org.example.chapter_1.section_3.impl;

public interface IQueue<Item> {
    boolean isEmpty();
    int size();
    void enqueue(Item item);
    Item dequeue();
}

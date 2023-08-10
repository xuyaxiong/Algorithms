package org.example.chapter_1.section_3;

public interface IQueue<Item> {
    boolean isEmpty();
    int size();
    void enqueue(Item item);
    Item dequeue();
}

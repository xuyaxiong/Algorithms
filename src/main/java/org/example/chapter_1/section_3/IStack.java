package org.example.chapter_1.section_3;

public interface IStack<Item> {
    boolean isEmpty();

    int size();

    void push(Item item);

    Item pop();
}

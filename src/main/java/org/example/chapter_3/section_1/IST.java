package org.example.chapter_3.section_1;

public interface IST<Key extends Comparable<Key>, Value> {
    int size();

    boolean isEmpty();

    void put(Key key, Value val);

    Value get(Key key);

    Iterable<Key> keys();

    void delete(Key key);
}

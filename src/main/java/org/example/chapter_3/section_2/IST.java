package org.example.chapter_3.section_2;

public interface IST<Key extends Comparable<Key>, Value> {
    int size();

    boolean isEmpty();

    void put(Key key, Value val);

    Value get(Key key);

    Iterable<Key> keys();

    void delete(Key key);

    void deleteMin();

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    Key select(int rank);

    int rank(Key key);
}

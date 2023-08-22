package org.example.chapter_3.section_1;

import edu.princeton.cs.algs4.StdOut;
import org.example.chapter_1.section_3.Queue;

public class Q3_1_2<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public Q3_1_2(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(Key key, Value val) {
        for (int i = 0; i < N; ++i) {
            if (keys[i].compareTo(key) == 0) {
                vals[i] = val;
                return;
            }
        }
        if (N == keys.length)
            resize(2 * keys.length);
        keys[N] = key;
        vals[N] = val;
        N++;
    }

    @Override
    public Value get(Key key) {
        for (int i = 0; i < N; ++i) {
            if (keys[i].compareTo(key) == 0)
                return vals[i];
        }
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        for (int i = 0; i < N; ++i)
            q.enqueue(keys[i]);
        return q;
    }

    @Override
    public void delete(Key key) {
        int i = 0;
        while (keys[i].compareTo(key) != 0) i++;
        for (int j = i + 1; j < N; ++j) {
            keys[j - 1] = keys[j];
            vals[j - 1] = vals[j];
        }
        keys[N] = null;
        N--;
        if (N == keys.length / 4)
            resize(keys.length / 2);
    }

    private void resize(int max) {
        Key[] oldKeys = keys;
        Value[] oldVals = vals;
        keys = (Key[]) new Comparable[max];
        vals = (Value[]) new Object[max];
        for (int i = 0; i < N; ++i) {
            keys[i] = oldKeys[i];
            vals[i] = oldVals[i];
        }
    }

    public static void main(String[] args) {
        Q3_1_2<String, Double> q312 = new Q3_1_2<>(1);
        q312.put("A+", 4.33);
        q312.put("A", 4.00);
        q312.put("A-", 3.67);
        q312.put("B+", 3.33);
        q312.put("B", 3.00);
        q312.put("B-", 2.67);
        q312.put("C+", 2.33);
        q312.put("C", 2.00);
        q312.put("C-", 1.67);
        q312.put("D", 1.00);
        q312.put("F", 0.00);

        q312.delete("A+");
        q312.delete("A-");
        q312.delete("B+");
        q312.delete("B-");
        q312.delete("C+");
        q312.delete("C-");
        q312.delete("F");

        for (String key : q312.keys()) {
            StdOut.println(key + " " + q312.get(key));
        }
    }
}

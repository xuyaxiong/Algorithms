package org.example.chapter_3.section_1;

import edu.princeton.cs.algs4.StdOut;
import org.example.chapter_1.section_3.Queue;

public class Q3_1_16<Key extends Comparable<Key>, Value> implements IST<Key, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N;

    public Q3_1_16() {
        keys = (Key[]) new Comparable[INIT_CAPACITY];
        vals = (Value[]) new Object[INIT_CAPACITY];
    }

    private void resize(int capacity) {
        Key[] oldKeys = keys;
        Value[] oldVals = vals;
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        for (int i = 0; i < N; ++i) {
            keys[i] = oldKeys[i];
            vals[i] = oldVals[i];
        }
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
    public Value get(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    }

    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        if (keys.length == N)
            resize(2 * N);
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i + 1; j < N; j++) {
                keys[j - 1] = keys[j];
                vals[j - 1] = vals[j];
            }
            keys[N - 1] = null;
            vals[N - 1] = null;
            N--;
            if (N > 0 && N == keys.length / 4) resize(keys.length / 2);
        }
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        for (int i = 0; i < N; ++i)
            q.enqueue(keys[i]);
        return q;
    }

    public static void main(String[] args) {
        Q3_1_16<String, Double> q3116 = new Q3_1_16<>();
        q3116.put("A+", 4.33);
        q3116.put("A", 4.00);
        q3116.put("A-", 3.67);
        q3116.put("B+", 3.33);
        q3116.put("B", 3.00);
        q3116.put("B-", 2.67);
        q3116.put("C+", 2.33);
        q3116.put("C", 2.00);
        q3116.put("C-", 1.67);
        q3116.put("D", 1.00);
        q3116.put("F", 0.00);

        q3116.delete("A+");
        q3116.delete("A-");
        q3116.delete("B+");
        q3116.delete("B-");
        q3116.delete("C+");
        q3116.delete("C-");
        q3116.delete("F");

        for (String key : q3116.keys()) {
            StdOut.println(key + " " + q3116.get(key));
        }
    }
}

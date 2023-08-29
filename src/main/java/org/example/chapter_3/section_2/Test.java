package org.example.chapter_3.section_2;

import edu.princeton.cs.algs4.StdOut;
import org.example.chapter_1.section_3.Queue;
import org.example.chapter_3.section_1.ST;

public class Test<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private Node root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) x = new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp < 0) return get(x.left, key);
        else return get(x.right, key);
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        keys(root, q, lo, hi);
        return q;
    }

    private void keys(Node x, Queue<Key> q, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, q, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) q.enqueue(x.key);
        if (cmphi > 0) keys(x.right, q, lo, hi);
    }

    private void keys(Queue<Key> q, Node x) {
        if (x == null) return;
        keys(q, x.left);
        q.enqueue(x.key);
        keys(q, x.right);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node x) {
        if (x == null) return null;
        else if (x.right == null) return x.key;
        else return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t == null) return x;
        else return t;
    }

    public Key select(int rank) {
        return select(root, rank);
    }

    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if (leftSize == rank) return x.key;
        else if (leftSize > rank) return select(x.left, rank);
        else return select(x.right, rank - leftSize - 1);
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return size(x.left);
        else if (cmp < 0) return rank(key, x.left);
        else return size(x.left) + 1 + rank(key, x.right);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        Test<Double, Integer> test = new Test<>();
        test.put(5.0, 5);
        test.put(3.0, 3);
        test.put(1.0, 1);
        test.put(9.0, 9);
        test.put(7.0, 7);
        test.put(6.0, 6);
        test.put(8.0, 8);
        test.put(2.0, 2);
        test.put(0.0, 0);
        test.put(4.0, 4);

        test.delete(5.0);
        test.delete(3.0);
        test.delete(7.0);

        for (Double key : test.keys()) {
            StdOut.println(key + " " + test.get(key));
        }
    }
}

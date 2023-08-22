package org.example.chapter_3.section_1;


import edu.princeton.cs.algs4.StdOut;
import org.example.chapter_1.section_3.Queue;

public class Q3_1_5<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private class Node {
        Key key;
        Value val;
        Node next;

        Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int N;
    private Node first;

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
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    @Override
    public Value get(Key key) {
        Node x = first;
        while (x != null) {
            if (x.key.compareTo(key) == 0)
                return x.val;
            x = x.next;
        }
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        Node temp = first;
        while (temp != null) {
            q.enqueue(temp.key);
            temp = temp.next;
        }
        return q;
    }

    @Override
    public void delete(Key key) {
        Node pre = null;
        Node curr = first;
        while (curr != null) {
            if (curr.key.compareTo(key) == 0) {
                if (pre == null)
                    first = first.next;
                else pre.next = curr.next;
                break;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        N--;
    }

    public static void main(String[] args) {
        Q3_1_5<String, Double> q315 = new Q3_1_5<>();
        q315.put("A+", 4.33);
        q315.put("A", 4.00);
        q315.put("A-", 3.67);
        q315.put("B+", 3.33);
        q315.put("B", 3.00);
        q315.put("B-", 2.67);
        q315.put("C+", 2.33);
        q315.put("C", 2.00);
        q315.put("C-", 1.67);
        q315.put("D", 1.00);
        q315.put("F", 0.00);

        q315.delete("A+");
        q315.delete("A-");
        q315.delete("B+");
        q315.delete("B-");
        q315.delete("C+");
        q315.delete("C-");
        q315.delete("F");

        for (String key : q315.keys()) {
            StdOut.println(key + " " + q315.get(key));
        }
    }
}

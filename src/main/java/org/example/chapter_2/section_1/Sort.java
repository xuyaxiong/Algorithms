package org.example.chapter_2.section_1;

import edu.princeton.cs.algs4.StdOut;

public class Sort {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; ++i)
            StdOut.print(a[i] + "");
        StdOut.println();
    }

    public static String toString(Comparable[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; ++i) {
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}

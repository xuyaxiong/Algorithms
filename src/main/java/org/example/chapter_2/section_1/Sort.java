package org.example.chapter_2.section_1;

import edu.princeton.cs.algs4.StdOut;

public abstract class Sort implements ISort {

    @Override
    public abstract void sort(Comparable[] a);

    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; ++i)
            StdOut.print(a[i] + "");
        StdOut.println();
    }

    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}

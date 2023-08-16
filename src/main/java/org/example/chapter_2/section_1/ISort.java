package org.example.chapter_2.section_1;

public interface ISort {
    void sort(Comparable[] a);

    boolean less(Comparable v, Comparable w);

    void exch(Comparable[] a, int i, int j);

    void show(Comparable[] a);

    boolean isSorted(Comparable[] a);
}

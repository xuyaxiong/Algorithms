package org.example.chapter_2.section_2;

import org.example.chapter_2.section_1.Sort;

public class Merge extends Sort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; ++i) {
            aux[i] = a[i];
        }
        int j = lo, k = mid + 1;
        for (int i = lo; i <= hi; ++i) {
            if (j > mid) {
                a[i] = aux[k++];
            } else if (k > hi) {
                a[i] = aux[j++];
            } else if (less(aux[j], aux[k])) {
                a[i] = aux[j++];
            } else {
                a[i] = aux[k++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 5, 7, 9, 0, 2, 4, 6, 8, 10};
        Merge.sort(a);
        Merge.show(a);
    }
}

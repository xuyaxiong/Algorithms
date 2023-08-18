package org.example.chapter_2.section_2;

import org.example.chapter_2.section_1.Sort;

public class MergeBU extends Sort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));

            }
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
        MergeBU.sort(a);
        MergeBU.show(a);
    }
}

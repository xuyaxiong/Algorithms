package org.example.chapter_2.section_1;

public class Shell extends Sort {
    public static void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; ++i) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}

package org.example.chapter_2.section_1;

public class Selection extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Character[] a = new Character[]{'h', 'e', 'l', 'l', 'o'};
        Selection.sort(a);
        assert Selection.isSorted(a);
        Selection.show(a);
    }
}
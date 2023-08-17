package org.example.chapter_2.section_1;

import org.example.utils.Util;

public class Selection extends Sort {
    public static void sort(Comparable[] a) {
        System.out.println(Util.getRedString(Selection.toString(a)));
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
//            show(a);
            String s = Selection.toString(a);
            showProcess(s, i + 1);
        }
    }

    private static void showProcess(String s, int split) {
        String pre = s.substring(0, split);
        String post = s.substring(split);
        System.out.print(Util.getGreenString(pre));
        System.out.println(Util.getRedString(post));
    }

    public static void main(String[] args) {
        String s = "SORTEXAMPLE";
        Character[] a = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            a[i] = s.charAt(i);
        }
        Selection.sort(a);
        assert Selection.isSorted(a);
        Selection.show(a);
    }
}
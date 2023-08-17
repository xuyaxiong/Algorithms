package org.example.chapter_2.section_1;

import org.example.utils.Util;

public class Insertion extends Sort {
    public static void sort(Comparable[] a) {
//        System.out.println(Util.getRedString(Selection.toString(a)));
        int N = a.length;
        for (int i = 1; i < N; ++i) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); --j) {
                exch(a, j - 1, j);
            }
//            showProcess(Selection.toString(a), i + 1);
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
        Insertion.sort(a);
        assert Insertion.isSorted(a);
        Insertion.show(a);
    }
}

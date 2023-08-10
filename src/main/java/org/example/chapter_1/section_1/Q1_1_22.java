package org.example.chapter_1.section_1;

public class Q1_1_22 {
    public static int rank(int key, int[] a, int lo, int hi, int level) {
        String info = getIndentation(level) + "lo = " + lo + " hi = " + hi;
        System.out.println(info);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return mid;
        else if (a[mid] < key)
            return rank(key, a, mid + 1, hi, level + 1);
        else
            return rank(key, a, lo, mid - 1, level + 1);
    }

    public static String getIndentation(int level) {
        StringBuilder sb = new StringBuilder();
        while (level-- > 0) {
            sb.append("\t");
        }
        return sb.toString();
    }
}

package org.example.chapter_1.section_4;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class TwoSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (a[i] + a[j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static int countFast(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; ++i)
            if (BinarySearch.indexOf(a, -a[i]) < i)
                cnt++;
        return cnt;
    }
}

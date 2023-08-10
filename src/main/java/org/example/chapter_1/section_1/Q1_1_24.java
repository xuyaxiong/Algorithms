package org.example.chapter_1.section_1;

public class Q1_1_24 {
    public static int euclid(int p, int q) {
        System.out.println(p + "\t" + q);
        if (q == 0) return p;
        int r = p % q;
        return euclid(q, r);
    }
}

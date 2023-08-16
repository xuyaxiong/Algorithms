package org.example.chapter_1.section_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF implements IUF {

    private int[] ids;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        ids = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; ++i) {
            ids[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (ids[p] != p) p = ids[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] >= sz[qRoot]) {
            ids[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            ids[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (weightedQuickUnionUF.connected(p, q)) continue;
            weightedQuickUnionUF.union(p, q);
//            StdOut.println(p + " " + q);
        }
        StdOut.println(weightedQuickUnionUF.count() + " components");
    }
}

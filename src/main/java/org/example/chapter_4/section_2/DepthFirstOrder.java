package org.example.chapter_4.section_2;

import edu.princeton.cs.algs4.In;
import org.example.chapter_1.section_3.Queue;
import org.example.chapter_1.section_3.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int v = 0; v < G.V(); ++v)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
        for (Integer v : depthFirstOrder.pre())
            System.out.print(v + " ");
        System.out.println();
        for (Integer v : depthFirstOrder.post())
            System.out.print(v + " ");
        System.out.println();
        for (Integer v : depthFirstOrder.reversePost())
            System.out.print(v + " ");
    }
}

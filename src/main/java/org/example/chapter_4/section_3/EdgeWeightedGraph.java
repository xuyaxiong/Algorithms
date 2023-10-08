package org.example.chapter_4.section_3;

import edu.princeton.cs.algs4.In;
import org.example.chapter_1.section_3.Bag;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; ++v)
            adj[v] = new Bag<>();
    }

    public EdgeWeightedGraph(In in) {
        V = in.readInt();
        adj = new Bag[V];
        for (int v = 0; v < V; ++v)
            adj[v] = new Bag<>();
        int E = in.readInt();
        for (int i = 0; i < E; ++i) {
            int v = in.readInt(), w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int v = 0; v < V; ++v)
            for (Edge e : adj(v))
                if (e.other(v) > v)
                    b.add(e);
        return b;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" ").append(E).append("\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (Edge e : adj[v]) {
                s.append(e).append("  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
        System.out.println(G);
    }
}

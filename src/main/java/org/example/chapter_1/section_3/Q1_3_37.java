package org.example.chapter_1.section_3;

public class Q1_3_37 {

    public static String josephus(int N, int M) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; ++i) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; ++i) {
                queue.enqueue(queue.dequeue());
            }
            sb.append(queue.dequeue());
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}

package chapter_1.section_4;

import edu.princeton.cs.algs4.StdRandom;
import org.example.chapter_1.section_4.TwoSum;
import org.example.utils.Util;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    @Test
    public void test() {
        int MAX = 1000000;
        int N = 10000;

        StringBuilder xStr = new StringBuilder();
        StringBuilder yStr = new StringBuilder();

        for (int i = 0; i < 20; ++i) {
            N += 10000;
            int[] a = new int[N];
            for (int j = 0; j < N; ++j) {
                a[j] = StdRandom.uniform(-MAX, MAX);
            }

            xStr.append(N);
            xStr.append(',');

            double time = Util.timeit(() -> TwoSum.count(a));
            yStr.append(time);
            yStr.append(',');
        }

        System.out.println(xStr.toString().trim());
        System.out.println(yStr.toString().trim());
    }
}

package chapter_1.section_4;

import edu.princeton.cs.algs4.StdRandom;
import org.example.chapter_1.section_4.TwoSum;
import org.example.utils.Util;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    @Test
    public void test() {
        int N = 100000;

        StringBuilder xStr = new StringBuilder();
        StringBuilder yStr = new StringBuilder();

        for (int i = 0; i < 10; ++i) {
            int temp = N + i * 10000;
            int[] a = genArr(temp);

            xStr.append(temp);
            xStr.append(',');

            double time = Util.timeit(() -> TwoSum.count(a));
            yStr.append(time);
            yStr.append(',');
        }

        System.out.println(xStr);
        System.out.println(yStr);
    }

    @Test
    public void testFast() {
        int N = 1000000;

        StringBuilder xStr = new StringBuilder();
        StringBuilder yStr = new StringBuilder();

        for (int i = 0; i < 41; ++i) {
            int temp = N + i * 100000;
            int[] a = genArr(temp);

            xStr.append(temp);
            xStr.append(',');

            double time = Util.timeit(() -> TwoSum.countFast(a));
            yStr.append(time);
            yStr.append(',');
        }

        System.out.println(xStr);
        System.out.println(yStr);
    }

    @Test
    public void doublingTest() {
        int N = 1000;
        double last = -1;
        for (int i = 0; i < 20; ++i) {
            N *= 2;
            int[] a = genArr(N);
            double time = Util.timeit(() -> TwoSum.countFast(a));
            if (last > 0) {
                System.out.println(time + "s " + time / last);
            }
            last = time;
        }
    }


    private int[] genArr(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int j = 0; j < N; ++j) {
            a[j] = StdRandom.uniform(-MAX, MAX);
        }
        return a;
    }
}

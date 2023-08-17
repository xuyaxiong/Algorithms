package chapter_2.section_1;

import edu.princeton.cs.algs4.StdRandom;
import org.example.chapter_2.section_1.Shell;
import org.example.utils.Util;
import org.junit.jupiter.api.Test;

public class ShellTest {
    @Test
    public void test() {
        Double[] a = genArr(10000);
        Shell.sort(a);
        assert Shell.isSorted(a);
    }

    @Test
    public void doublingTestShell() {
        int N = 1000;
        double last = -1;
        for (int i = 0; i < 10; ++i) {
            N *= 2;
            Double[] a = genArr(N);
            double time = Util.timeit(() -> Shell.sort(a));
            if (last > 0) {
                System.out.printf("%6.3fs %.1f\n", time, time / last);
            }
            last = time;
        }
    }

    private static Double[] genArr(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }
}

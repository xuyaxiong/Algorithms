package chapter_2.section_1;

import edu.princeton.cs.algs4.StdRandom;
import org.example.chapter_2.section_1.Selection;
import org.example.utils.Util;
import org.junit.jupiter.api.Test;

public class SelectionTest {
    @Test
    public void doublingTestSelection() {
        int N = 1000;
        double last = -1;
        for (int i = 0; i < 8; ++i) {
            N *= 2;
            Double[] a = genArr(N);
            double time = Util.timeit(() -> Selection.sort(a));
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

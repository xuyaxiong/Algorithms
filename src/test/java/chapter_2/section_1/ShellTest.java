package chapter_2.section_1;

import edu.princeton.cs.algs4.StdRandom;
import org.example.chapter_2.section_1.Shell;
import org.junit.jupiter.api.Test;

public class ShellTest {
    @Test
    public void test() {
        Double[] a = genArr(10000);
        Shell.sort(a);
        assert Shell.isSorted(a);
    }

    private static Double[] genArr(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }
}

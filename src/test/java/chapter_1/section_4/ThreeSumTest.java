package chapter_1.section_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.example.chapter_1.section_4.ThreeSum;
import org.example.utils.Util;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ThreeSumTest {
    @Test
    @Order(1)
    public void test1Kints() {
        String path = Util.getResourcePath("section4/1Kints.txt");
        int[] a = In.readInts(path);
        Util.timeit(() -> StdOut.println(ThreeSum.count(a)));
    }

    @Test
    @Order(2)
    public void test2Kints() {
        String path = Util.getResourcePath("section4/2Kints.txt");
        int[] a = In.readInts(path);
        Util.timeit(() -> StdOut.println(ThreeSum.count(a)));
    }

    @Test
    @Order(3)
    public void test4Kints() {
        String path = Util.getResourcePath("section4/4Kints.txt");
        int[] a = In.readInts(path);
        Util.timeit(() -> StdOut.println(ThreeSum.count(a)));
    }

    @Test
    @Order(4)
    public void test8Kints() {
        String path = Util.getResourcePath("section4/8Kints.txt");
        int[] a = In.readInts(path);
        Util.timeit(() -> StdOut.println(ThreeSum.count(a)));
    }

    @Test
    @Order(5)
    public void test() {
        int N = 4000;
        StringBuilder xStr = new StringBuilder();
        StringBuilder yStr = new StringBuilder();
        for (int i = 5; i < 8; ++i) {
            int temp = N + i * 1000;
            int[] a = genArr(temp);
            xStr.append(temp);
            xStr.append(',');
            double time = Util.timeit(() -> ThreeSum.count(a));
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
        for (int i = 0; i < 10; ++i) {
            N *= 2;
            int[] a = genArr(N);
            double time = Util.timeit(() -> ThreeSum.count(a));
            if (last > 0) {
                System.out.println(time + "s " + time / last);
            }
            last = time;
        }
    }

    @Test
    public void doublingTestFast() {
        int N = 1000;
        double last = -1;
        for (int i = 0; i < 10; ++i) {
            N *= 2;
            int[] a = genArr(N);
            double time = Util.timeit(() -> ThreeSum.countFast(a));
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

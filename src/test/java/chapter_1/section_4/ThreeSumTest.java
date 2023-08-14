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
        int MAX = 1000000;
        int N = 4000;

        for (int i = 0; i < 25; ++i) {
            N += 500;
            int[] a = new int[N];
            for (int j = 0; j < N; ++j) {
                a[j] = StdRandom.uniform(-MAX, MAX);
            }
            System.out.println(N);
            Util.timeit(() -> ThreeSum.count(a));
        }
    }
}

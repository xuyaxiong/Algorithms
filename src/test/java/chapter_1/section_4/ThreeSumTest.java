package chapter_1.section_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.example.chapter_1.section_4.ThreeSum;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {
    @Test
    public void test() {
        String path = "C:\\Users\\xuyax\\Downloads\\8Kints.txt";
        int[] a = In.readInts(path);
        StdOut.println(ThreeSum.count(a));
    }
}

package chapter_1.section_1;

import org.example.chapter_1.section_1.Q_1_1_22;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T_1_1_22 {
    @Test
    public void testRank() {

        int[] arr = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        assertEquals(0, Q_1_1_22.rank(10, arr, 0, arr.length - 1, 0));
        assertEquals(5, Q_1_1_22.rank(15, arr, 0, arr.length - 1, 0));
        assertEquals(10, Q_1_1_22.rank(20, arr, 0, arr.length - 1, 0));
        assertEquals(-1, Q_1_1_22.rank(5, arr, 0, arr.length - 1, 0));
        assertEquals(-1, Q_1_1_22.rank(25, arr, 0, arr.length - 1, 0));

    }
}

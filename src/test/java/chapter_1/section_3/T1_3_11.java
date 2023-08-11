package chapter_1.section_3;

import org.example.chapter_1.section_3.Q1_3_11;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_3_11 {
    @Test
    public void test() {
        assertEquals(277, Q1_3_11.evaluatePostfix("1 2 3 4 5 * + 6 * * +"));
        assertEquals(30001, Q1_3_11.evaluatePostfix("7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +"));
        assertEquals(27, Q1_3_11.evaluatePostfix("3 4 5 + *"));
    }
}

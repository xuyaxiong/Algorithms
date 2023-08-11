package chapter_1.section_3;

import org.example.chapter_1.section_3.Q1_3_4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class T1_3_4 {
    @Test
    public void test() {
        assertTrue(Q1_3_4.isBalanced("[()]{}{[()()]()}"));
        assertFalse(Q1_3_4.isBalanced("[(])"));
        assertFalse(Q1_3_4.isBalanced("(((){[]}[()])"));
    }
}

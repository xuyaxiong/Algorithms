package chapter_1.section_3;

import org.example.chapter_1.section_3.Q1_3_37;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class T1_3_37 {
    @Test
    public void test() {
        assertEquals("1 3 5 0 4 2 6", Q1_3_37.josephus(7, 2));
    }
}

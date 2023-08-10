package chapter_1.section_1;

import org.example.chapter_1.section_1.Q1_1_24;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_1_24 {
    @Test
    public void testEuclid() {
        assertEquals(1, Q1_1_24.euclid(1111111, 1234567));
        assertEquals(7, Q1_1_24.euclid(98, 63));
        assertEquals(52, Q1_1_24.euclid(260, 104));
    }
}

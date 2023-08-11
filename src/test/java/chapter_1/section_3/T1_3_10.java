package chapter_1.section_3;

import org.example.chapter_1.section_3.Q1_3_10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class T1_3_10 {
    @Test
    public void test() {
        assertEquals("2 3 4 + 5 6 * * +", Q1_3_10.infixToPostfix("( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )"));
        assertEquals("5 7 1 1 + * + 3 * 2 1 1 + * +", Q1_3_10.infixToPostfix("( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )"));
    }
}

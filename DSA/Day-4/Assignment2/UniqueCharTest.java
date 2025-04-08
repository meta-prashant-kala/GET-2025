import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueCharTest {

    private UniqueChar uniqueChar;

    @BeforeEach
    public void initialise() {
        uniqueChar = new UniqueChar();
    }

    @Test
    public void countUniqueChars1() {
        String input = "";
        int expected = 0;
        int actual = uniqueChar.countUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void countUniqueChars2() {
        String input = "abcd";
        int expected = 4;
        int actual = uniqueChar.countUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void countUniqueChars3() {
        String input = "aabbcc";
        int expected = 0;
        int actual = uniqueChar.countUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void countUniqueChars4() {
        String input = "aabcde";
        int expected = 4;
        int actual = uniqueChar.countUniqueChars(input);
        assertEquals(expected, actual);
    }

    @Test
    public void countUniqueChars5() {
        String input = "abc";
        int expected = 3;
        uniqueChar.countUniqueChars(input); 
        int actual = uniqueChar.countUniqueChars(input);
        assertEquals(expected, actual);
    }
}
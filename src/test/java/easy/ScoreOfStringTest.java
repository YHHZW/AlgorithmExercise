package easy;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreOfStringTest {

    public int scoreOfString(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0, len = s.length(); i < len - 1; i++) {
            count += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return count;
    }

    @Test
    public void test1() {
        assertEquals(scoreOfString("hello"), 13);
    }

    @Test
    public void test2() {
        assertEquals(scoreOfString("zaz"), 50);
    }

}

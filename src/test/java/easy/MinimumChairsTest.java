package easy;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinimumChairsTest {

    public int minimumChairs(String s) {
        char[] a = s.toCharArray();
        int max = 0, temp = 0;
        for (int i = 0, len = a.length; i < len; i++) {
            if (a[i] == 'E') {
                max = Math.max(++temp, max);
            } else {
               --temp;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        assertEquals(minimumChairs("EEEEEEE"), 7);
    }

    @Test
    public void test2() {
        assertEquals(minimumChairs("ELELEEL"), 2);
    }

    @Test
    public void test3() {
        assertEquals(minimumChairs("ELEELEELLL"), 3);
    }

    @Test
    public void test4() {
        assertEquals(minimumChairs("EEEEEELELLLE"), 6);
    }

}

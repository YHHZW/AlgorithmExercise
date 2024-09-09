package medium;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinPartitionsTest {

    public int minPartitions(String n) {
        int result = 0;
        for (int i = 0, len = n.length(); i < len; i++) {
            int temp = n.charAt(i) - '0';
            result = Math.max(result, temp);
        }
        return result;
    }

    public int minPartitions2(String n) {
        char[] a = n.toCharArray();
        int max = 0;
        for (int i = 0, len = a.length; i < len; i++) {
            if (a[i] - 48 > max) {
                max = a[i] - 48;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        assertEquals(minPartitions2("32"), 3);
    }

    @Test
    public void test2() {
        assertEquals(minPartitions2("82734"), 8);
    }

    @Test
    public void test3() {
        assertEquals(minPartitions2("27346209830709182346"), 9);
    }

}

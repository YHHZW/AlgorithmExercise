package medium;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringHashTest {

    public String stringHash(String s, int k) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = charArr.length; i < len; i += k) {
            int temp = 0;
            for (int j = i; j < i + k; j++) {
                temp += (charArr[j] - 'a');
            }
            sb.append((char) (temp % 26 + 97));
        }
        return sb.toString();
    }


    @Test
    public void test1() {
        assertEquals(stringHash("abcd", 2), "bf");
    }

    @Test
    public void test2() {
        assertEquals(stringHash("mxz", 3), "i");
    }

}

package easy;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddBinaryTest {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        int carry = 0;
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int len = Math.max(aLen, bLen);
        for (int i = 0; i <= len; i++) {
            int sum = carry;
            sum += aLen - i >= 0 ? a.charAt(aLen - i) - '0' : 0;
            sum += bLen - i >= 0 ? b.charAt(bLen - i) - '0' : 0;

            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    @Test
    public void test1() {
        assertEquals(addBinary("11", "1"), "100");
    }

    @Test
    public void test2() {
        assertEquals(addBinary("1010", "1011"), "10101");
    }


}

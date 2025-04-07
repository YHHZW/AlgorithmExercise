package easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinimumSumTest {

    public int minimumSum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);

        String a = "" + chars[0] + chars[2];
        String b = "" + chars[1] + chars[3];

        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public int minimumSum2(int num) {
        int[] digits = new int[4];
        for (int i = 0; num > 0;) {
            digits[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);
        return 10 * (digits[0] + digits[1]) + digits[2] + digits[3];
    }

    @Test
    public void test() {
        assertEquals(minimumSum2(2932), 52);
    }

    @Test
    public void test2() {
        assertEquals(minimumSum2(4009), 13);
    }


}

package easy;

import org.junit.Test;
import static org.junit.Assert.*;

public class MakeSmallestPalindromeTest {

    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i = 0, j = len - 1; i <= len / 2 && j >= len / 2; i++, j--) {
            if (s.charAt(i) > s.charAt(j)) {
                sb.setCharAt(i, s.charAt(j));
            } else if (s.charAt(i) < s.charAt(j)) {
                sb.setCharAt(j, s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String makeSmallestPalindrome2(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                arr[left] = arr[right] = (char) Math.min(arr[left], arr[right]);
            }
            ++left;
            --right;
        }
        return new String(arr);
    }

    @Test
    public void test1() {
        assertEquals(makeSmallestPalindrome2("egcfe"), "efcfe");
    }

    @Test
    public void test2() {
        assertEquals(makeSmallestPalindrome2("abcd"), "abba");
    }

    @Test
    public void test3() {
        assertEquals(makeSmallestPalindrome2("seven"), "neven");
    }

}

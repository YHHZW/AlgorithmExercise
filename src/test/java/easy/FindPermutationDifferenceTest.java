package easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FindPermutationDifferenceTest {

    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, len = t.length(); i < len; i++) {
            map.put(t.charAt(i), i);
        }

        int result = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            int j = map.get(s.charAt(i));
            result += Math.abs(j - i);
        }
        return result;
    }

    public int findPermutationDifference2(String s, String t) {
        int[] temp = new int[26];
        for (int i = 0, len = t.length(); i < len; i++) {
            temp[t.charAt(i) - 'a'] = i;
        }

        int result = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            int j = temp[s.charAt(i) - 'a'];
            result += Math.abs(j - i);
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(findPermutationDifference2("abc", "bac"), 2);
    }

    @Test
    public void test2() {
        assertEquals(findPermutationDifference2("abcde", "edbac"), 12);
    }

}

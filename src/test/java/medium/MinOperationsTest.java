/**
 * 1769、移动所有球到每个盒子所需的最小操作数
 */
package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinOperationsTest {

    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                indexs.add(i);
            }
        }
        for (int i = 0; i < boxes.length(); i++) {
            int temp = 0;
            for (int index : indexs) {
                temp += Math.abs(i - index);
            }
            answer[i] = temp;
        }
        return answer;
    }

    public int[] minOperations2(String boxes) {
        int[] answer = new int[boxes.length()];
        int lc = boxes.charAt(0) - '0';
        int rc = 0;
        for (int i = 1, len = boxes.length(); i < len; i++) {
            if (boxes.charAt(i) == '1') {
                ++rc;
                answer[0] += i;
            }
        }
        for (int i = 1, len = boxes.length(); i < len; i++) {
            answer[i] = answer[i - 1] + lc - rc;
            if (boxes.charAt(i) == '1') {
                ++lc;
                --rc;
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertArrayEquals(minOperations2("110"), new int[] {1, 1, 3});
    }

    @Test
    public void test2() {
        assertArrayEquals(minOperations2("001011"), new int[] {11, 8, 5, 4, 3, 4});
    }
}

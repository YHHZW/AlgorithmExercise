package easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MinOperationsTest {

    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (set.contains(num)) {
                continue;
            }
            if (num > k) {
                set.add(num);
            }
        }
        return set.size();
    }

    @Test
    public void test() {
        int[] nums = new int[]{5,2,5,4,5};
        assertEquals(minOperations(nums, 2), 2);
    }

    @Test
    public void test1() {
        int[] nums = new int[]{2,1,2};
        assertEquals(minOperations(nums, 2), -1);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{9,7,5,3};
        assertEquals(minOperations(nums, 1), 4);
    }

}

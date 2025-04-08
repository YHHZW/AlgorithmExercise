package easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MinimumOperationsTest {

    public int minimumOperations(int[] nums) {
        boolean[] booleans = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (booleans[nums[i]]) {
                return i / 3 + 1;
            }
            booleans[nums[i]] = true;
        }
        return 0;
    }

    public int minimumOperations2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i += 3) {
            if (checkNumsRepetition(i, nums)) {
                return result;
            }
            ++result;
        }
        return result;
    }

    public boolean checkNumsRepetition(int index, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,2,3,3,5,7};
        assertEquals(minimumOperations2(nums), 2);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{4,5,6,4,4};
        assertEquals(minimumOperations2(nums), 2);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{6,7,8,9};
        assertEquals(minimumOperations2(nums), 0);
    }

}

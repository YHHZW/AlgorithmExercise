package easy;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Arrays;

public class NumberGameTest {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    @Test
    public void test1() {
        assertArrayEquals(numberGame(new int[] {5, 4, 2, 3}), new int[] {3, 2, 5, 4});
    }

    @Test
    public void test2() {
        assertArrayEquals(numberGame(new int[] {2, 5}), new int[] {5, 2});
    }

}

package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetMinDistanceTest {

    public int getMinDistance(int[] nums, int target, int start) {
        if (nums.length == 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(i - start));
            }
        }

        return min;
    }

    @Test
    public void test1() {
        assertEquals(1, getMinDistance(new int[] { 1, 2, 3, 4, 5 }, 5, 3));
    }

    @Test
    public void test2() {
        assertEquals(0, getMinDistance(new int[] { 1 }, 1, 0));
    }

    @Test
    public void test3() {
        assertEquals(0, getMinDistance(new int[] { 1,1,1,1,1,1,1,1,1,1 }, 1, 0));
    }

}

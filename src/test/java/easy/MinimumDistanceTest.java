package easy;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MinimumDistanceTest {

    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] last = new int[n + 1];
        int[] last2 = new int[n + 1];
        Arrays.fill(last, -n);
        Arrays.fill(last2, -n); // i-(-n) >= n，不会把 ans 变小

        int ans = n;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            ans = Math.min(ans, i - last2[x]);
            last2[x] = last[x];
            last[x] = i;
        }

        return ans == n ? -1 : ans * 2;
    }

    public int minimumDistance2(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = map.get(nums[i]);
            if (temp == null) {
                List<Integer> list = new ArrayList<>(nums.length / 3);
                list.add(i);
                map.put(nums[i], list);
            } else  {
                temp.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) {
                continue;
            }

            for (int i = 0; i <= list.size() - 3; i++) {
                int result = computeMinimumDistance(list.get(i), list.get(i + 1), list.get(i + 2));
                min = Math.min(min, result);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    public int computeMinimumDistance(int num1, int num2, int num3) {
        return Math.abs(num1 - num2) + Math.abs(num2 - num3) + Math.abs(num3 - num1);
    }

    @Test
    public void test1() {
        assertEquals(6, minimumDistance(new int[]{1, 2, 1, 1, 3}));
    }

    @Test
    public void test2() {
        assertEquals(8, minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 2}));
    }

    @Test
    public void test3() {
        assertEquals(-1, minimumDistance(new int[]{1}));
    }

    @Test
    public void test4() {
        assertEquals(4, minimumDistance(new int[]{5,3,5,5,5}));
    }
}

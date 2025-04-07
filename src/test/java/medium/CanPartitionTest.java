package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CanPartitionTest {

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i > nums.length / 2 - 1) {
            int leftSum = 0, rightSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftSum += nums[j];
            }

            for (int j = i; j < nums.length; j++) {
                rightSum += nums[j];
            }

            System.out.println("leftSum = " + leftSum + ", rightSum = " + rightSum);
            if (leftSum == rightSum) {
                return true;
            }
            --i;
        }
        return false;
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        assertTrue(canPartition3(new int[]{1, 5, 11, 5}));
    }

    @Test
    public void test2() {
        assertFalse(canPartition3(new int[]{1, 2, 3, 5}));
    }

}

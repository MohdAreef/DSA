/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place 
are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting 
the police.
  */
/*
Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
*/

class Solution {
    public int memoization(int index, int[] nums, int[] dp) {
        if (index == 0)
            return nums[index];
        if (index < 0)
            return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + memoization(index - 2, nums, dp);
        int nonpick = memoization(index - 1, nums, dp);

        return dp[index] = Math.max(pick, nonpick);
    }

    public int rob(int[] nums) {

        int n = nums.length;
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        int size = temp1.length;
        int i;
        for (i = 0; i < n - 1; i++) {
            temp1[i] = nums[i];
        }
        for (i = 1; i < n; i++) {
            temp2[i - 1] = nums[i];
        }

        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        int a = memoization(n - 2, temp1, dp);
        Arrays.fill(dp, -1);
        int b = memoization(n - 2, temp2, dp);

        return Math.max(a, b);

    }
}

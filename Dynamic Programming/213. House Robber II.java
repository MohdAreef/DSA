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
    public int memoization1(int index, int[] nums, int[] dp) {
        if (index == 0)
            return nums[index];
        if (index < 0)
            return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + memoization1(index - 2, nums, dp);
        int nonpick = memoization1(index - 1, nums, dp);

        return dp[index] = Math.max(pick, nonpick);
    }

    public int memoization2(int index, int[] nums, int[] dp) {
        if (index == 1)
            return nums[index];
        if (index < 1)
            return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + memoization2(index - 2, nums, dp);
        int nonpick = memoization2(index - 1, nums, dp);

        return dp[index] = Math.max(pick, nonpick);
    }

    public int rob(int[] nums) {

        int n = nums.length;

       //edge case
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int a = memoization1(n - 2, nums, dp);
        Arrays.fill(dp, -1);
        int b = memoization2(n - 1, nums, dp);

        return Math.max(a, b);

    }
}

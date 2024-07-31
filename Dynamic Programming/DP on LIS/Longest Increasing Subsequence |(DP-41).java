/*
Given an integer array nums, return the length of the longest strictly increasing 
subsequence.
  
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/

class Solution {
    public int max(int index, int prev_index, int[] nums, int[][] dp) {

        // base condition
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prev_index + 1] != -1)
            return dp[index][prev_index + 1];

        // explore
        int pick = Integer.MIN_VALUE;
        int nonpick = Integer.MIN_VALUE;
        if (prev_index == -1 || nums[index] > nums[prev_index]) {
            pick = (1 + max(index + 1, index, nums, dp));
        }

        nonpick = max(index + 1, prev_index, nums, dp);

        int ans = Math.max(pick, nonpick);

        return dp[index][prev_index + 1] = ans;

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return max(0, -1, nums, dp);
    }
}

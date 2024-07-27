// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is
// equal or false otherwise.

class Solution {
    public boolean partition(int index, int target, int[] nums, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index < 0)
            return false;

        if (dp[index][target] != -1) {
            return dp[index][target] == 1 ? true : false;
        }

        boolean pick = false;
        if (target >= nums[index]) {
            pick = partition(index - 1, target - nums[index], nums, dp);
        }

        boolean nonpick = partition(index - 1, target, nums, dp);
        dp[index][target] = pick || nonpick ? 1 : 0;
        return pick || nonpick;

    }

    public boolean canPartition(int[] nums) {
        int i, j, sum = 0;
        int n = nums.length;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        else {
            int[][] dp = new int[n + 1][sum / 2 + 1];
            for (i = 0; i <= n; i++) {
                for (j = 0; j <= sum / 2; j++) {
                    dp[i][j] = -1;
                }
            }
            return partition(n - 1, sum / 2, nums, dp);
        }
    }
}

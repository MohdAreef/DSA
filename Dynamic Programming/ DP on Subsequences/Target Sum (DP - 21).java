/* 
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
*/

class Solution {
    public int findways(int index, int target, int[] nums, int n, int sum, int[][] dp) {
        if (index == (n - 1)) {
            // add
            if (nums[index] == 0 && target == sum) {
                return 2;
            } else if (target + nums[index] == sum) {
                return 1;
            } else if (target - nums[index] == sum) {
                return 1;
            } else
                return 0;
        }

        if (target >= 0 && dp[index][target] != -1) {
            return dp[index][target];
        }

        int plus = findways(index + 1, target + nums[index], nums, n, sum, dp);

        int minus = findways(index + 1, target - nums[index], nums, n, sum, dp);

        return plus + minus;
    }

    public int findtarget(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            if (target == 0 && nums[index] == 0) {
                return 2;
            } else if (target == nums[index]) {
                return 1;
            } else if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[index][target] != -1)
            return dp[index][target];

        int nonpick = findtarget(index - 1, target, nums, dp);
        int pick = 0;
        if (target >= nums[index]) {

            pick = findtarget(index - 1, target - nums[index], nums, dp);
        }
        return pick + nonpick;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        // return findways(0,0,nums,n,target,dp);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int newtarget = ((sum - target) / 2);
        if ((sum - target) < 0 || (sum - target) % 2 != 0)
            return 0;
        int[][] dp = new int[n][newtarget + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return findtarget(n - 1, newtarget, nums, dp);

    }
}

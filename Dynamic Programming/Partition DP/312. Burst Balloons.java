/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to 
burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat
it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.
Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
*/
class Solution {
    public int burst(int i, int j, int[] nums, int[][] dp) {
        // base condition
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        // explore
        int mini = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = nums[i - 1] * nums[index] * nums[j + 1] + burst(i, index - 1, nums, dp)
                    + burst(index + 1, j, nums, dp);
            mini = Math.max(mini, cost);
        }
        return dp[i][j] = mini;
    }

    public int maxCoins(int[] nums) {

        int[] temp = new int[nums.length + 2];
        temp[0] = 1;
        temp[temp.length - 1] = 1;
        for (int i = 1; i < temp.length - 1; i++) {
            temp[i] = nums[i - 1];
        }
        // System.out.println(Arrays.toString(temp));
        int[][] dp = new int[temp.length][temp.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return burst(1, temp.length - 2, temp, dp);

    }
}

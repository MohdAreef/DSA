/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
*/

class Solution {
    public int max(int index, int buy, int count, int[] prices, int[][][] dp) {
        // base conditions
        if (index >= prices.length || count == 0)
            return 0;

        if (dp[index][buy][count] != -1)
            return dp[index][buy][count];

        int profit = 0;
        // explore
        if (buy == 1) {
            profit = Math.max(-prices[index] + max(index + 1, 0, count - 1, prices, dp),
                    max(index + 1, 1, count, prices, dp));
        } else {
            profit = Math.max(prices[index] + max(index + 1, 1, count - 1, prices, dp),
                    max(index + 1, 0, count, prices, dp));
        }

        return dp[index][buy][count] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return max(0, 1, 4, prices, dp);

    }
}

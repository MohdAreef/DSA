/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
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

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        // for k=2 he can make total of 2*k transactions
        // so total count of transactions=2*k;
        int count = 2 * k;
        int[][][] dp = new int[n][2][count + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int a = 0; a < count + 1; a++) {
                    dp[i][j][a] = -1;
                }
            }
        }

        return max(0, 1, count, prices, dp);

    }
}

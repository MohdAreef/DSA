/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the 
stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {
    public int max(int index, int buy, int[] prices, int[][] dp) {
        // base condition
        if (index >= prices.length)
            return 0;

        if (dp[index][buy] != -1)
            return dp[index][buy];

        // explore
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[index] + max(index + 1, 0, prices, dp), max(index + 1, 1, prices, dp));
        } else {
            profit = Math.max(prices[index] + max(index + 2, 1, prices, dp), max(index + 1, 0, prices, dp));
        }
        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return max(0, 1, prices, dp);

    }
}

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each 
transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
*/

class Solution {

    public int max(int index, int buy, int[] prices, int fee, int[][] dp) {
        // base condition
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1)
            return dp[index][buy];

        // explore
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[index] - fee + max(index + 1, 0, prices, fee, dp),
                    max(index + 1, 1, prices, fee, dp));
        } else {
            profit = Math.max(prices[index] + max(index + 1, 1, prices, fee, dp), max(index + 1, 0, prices, fee, dp));
        }
        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return max(0, 1, prices, fee, dp);

    }
}

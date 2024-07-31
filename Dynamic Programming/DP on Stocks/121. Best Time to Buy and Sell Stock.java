/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

class Solution {
    public int max(int[] prices)
    {
        int i;
        int profit=0;
        int mini=prices[0];
        for(i=1;i<prices.length;i++)
        {
            if((prices[i]-mini)>profit)
            {
                profit=prices[i]-mini;
            }

            if(prices[i]<mini)
            {
                mini=prices[i];
            }
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        return max(prices);
    }
}

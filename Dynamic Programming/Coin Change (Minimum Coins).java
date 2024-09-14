/*
Given an array coins[] represent the coins of different denominations and a target value sum. You have an infinite supply of each of the valued 
coins{coins1, coins2, ..., coinsm}.  Find the minimum number of coins to make the change. If not possible to make a change then return -1.

Examples:

Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5  
Input: coins[] = [9, 6, 5, 1], sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1

*/

class Solution {
    
    //Greedy approach
    public int min(int[] coins,int m,int sum)
    {
        Arrays.sort(coins );
        
        // System.out.println(Arrays.toString(coins));
        
        int n=coins.length;
        int i=n-1,count=0;
        while(i>=0)
        {
            if(sum==0) return count;
            if(coins[i]<=sum)
            {
                sum-=coins[i];
                count++;
            }
            else
            {
                i--;
            }
        }
        return count;
    }
    
    //Dynamic Programming 
    public int minchange(int index,int[] coins,int sum,int[][] dp)
    {
        //base condition
        if(sum==0)
        return 0;
        
        if(index==coins.length)
        {
            return (int)1e9;
        }
        
        if(dp[index][sum]!=-1) return dp[index][sum];
        
        int pick=(int) 1e9;
        //explore
        if(coins[index]<=sum)
        {
       pick= 1+minchange(index,coins,sum-coins[index],dp);
        }
        
       int nonpick= minchange(index+1,coins,sum,dp);
       
       return dp[index][sum]=Math.min(pick,nonpick);
        
    }
    public int minCoins(int coins[], int M, int sum) {
        // Your code goes here
        int n=coins.length;
        int[][] dp=new int[n][sum+1];
        for(int[] i:dp)
        {
            Arrays.fill(i,-1);
        }
        int ans= minchange(0,coins,sum,dp);
        if(ans==(int)1e9) return -1;
        return ans;
    }
}

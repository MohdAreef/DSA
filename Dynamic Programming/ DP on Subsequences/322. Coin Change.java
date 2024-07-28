/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, 
return -1.

You may assume that you have an infinite number of each kind of coin.
*/
class Solution {
    public int count(int index,int target,int[] coins,int[][] dp)
    {
        if(index==0) 
        {
            if(target%coins[index]==0) return target/coins[index];

            else
             return (int) 1e9;
        }
        if(dp[index][target]!=-1) return dp[index][target];

        int nonpick=count(index-1,target,coins,dp);
        int pick=(int) 1e9;
        if(target>=coins[index])
        {
        pick=1+count(index,target-coins[index],coins,dp);

        }

        return dp[index][target]=Math.min(pick,nonpick);
    }
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] i:dp)
        {
              Arrays.fill(i,-1);
        }
     int cnt= count(n-1,amount,coins,dp);
     if(cnt==(1e9)) return -1;
     else return cnt;
    }
}

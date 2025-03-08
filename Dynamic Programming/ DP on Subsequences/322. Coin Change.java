/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, 
return -1.

You may assume that you have an infinite number of each kind of coin.
*/
// MEMOIZATION
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
// MEMOIZATON -- Slite change in base case
class Solution {
    public int change(int index, int amount, int[] coins, int[][] dp) {

        if (amount == 0)
            return 0;

        if (index == 0) {
            if (amount % coins[index] == 0)
                return amount / coins[index];
            else
                return (int) 1e9;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int pick = (int) 1e9;
        if (coins[index] <= amount)
            pick = 1 + change(index, amount - coins[index], coins, dp);

        int notpick = change(index - 1, amount, coins, dp);

        return dp[index][amount] = Math.min(pick, notpick);

    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for(int[] d:dp)Arrays.fill(d,-1);

        int ans= change(n-1,amount,coins,dp);

        if(ans==(int)1e9) return -1;
        return ans;

    }
}

// TABULATION

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
   
        for (int index = 0; index < n; index++)
            dp[index][0] = 0;

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                dp[0][amt] = amt / coins[0];
            else
                dp[0][amt] = (int) 1e9;
        }

        for (int index = 1; index < n; index++) {
            for (int amt = 1; amt <= amount; amt++) {
                int pick = (int) 1e9;
                if (coins[index] <= amt) {
                    pick = 1 + dp[index][amt - coins[index]];
                }
                int notpick = dp[index - 1][amt];

                dp[index][amt] = Math.min(pick, notpick);
            }
        }

        if (dp[n - 1][amount] == (int) 1e9)
            return -1;
        return dp[n - 1][amount];

    }
}

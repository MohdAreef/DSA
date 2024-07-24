/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
*/

class Solution {
    public int climb(int n,int[] dp)
    {
        if(n==0) return 1;
        if(n==1) return 1;  

        if(dp[n]!=-1)
        {
            return dp[n];
        }

       return  dp[n]=climb(n-1,dp) + climb(n-2,dp); 
    }
    public int climbStairs(int n) {
         int[] dp=new int[n+1];
         Arrays.fill(dp,-1);
        return climb(n,dp);
        
    }
}

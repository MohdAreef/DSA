
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping 
you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent
houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting 
the police.
*/
// USING MEMOIZATION

class Solution {
    public int  memoization(int index , int[] nums,int[] dp)
    {
        if(index==0) return nums[index];
        if(index < 0 ) return 0;
        if(dp[index]!=-1)
        {
            return dp[index];
        }
       
        int pick=nums[index] + memoization(index-2 , nums,dp);
        int nonpick =  memoization(index-1,nums,dp);

        return dp[index]=  Math.max(pick,nonpick);

    }

    public int rob(int[] nums) {
       int n=nums.length-1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return memoization(n,nums,dp);
      
        
    }
}

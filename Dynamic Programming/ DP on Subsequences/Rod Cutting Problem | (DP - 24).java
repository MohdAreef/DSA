/*
Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the value of a piece of length i. Determine the maximum value 
obtainable by cutting up the rod and selling the pieces.
Example:
Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
*/
// MEMOIZATION SOLUTION
class Solution {
    public int maxprice(int index,int length,int[] price,int[][] dp)
    {
        if(length==0) return 0;
        if(index==1)
        {
            if(index<=length) return price[index-1] * (length/index);
            return (int)-1e9;
        }
        
        if(dp[index][length]!=-1) return dp[index][length];
        
        //explore
        int pick=(int)-1e9;
        if(index <= length)
         pick= price[index-1] + maxprice(index,length-index,price,dp);
         int notpick=maxprice(index-1,length,price,dp);
         
         return dp[index][length]=Math.max(pick,notpick);
        
    }
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp)
        Arrays.fill(d,-1);
        return maxprice(n,n,price,dp);
    }
}

// TABULATION
class Solution {
        public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp)
        Arrays.fill(d,-1);
        
        for(int i=0;i<(n+1);i++)
        dp[i][0]=0;
        
        for(int len=0;len<=n;len++)
        {
            if(1<=len) dp[1][len] = price[0] * ( len / 1); 
            else dp[1][len]=(int)-1e9;
        }
        
        for(int index=2;index<(n+1);index++)
        {
            for(int len=1;len<(n+1);len++)
            {
                int pick=(int)-1e9;
                if(index <= len)
                pick=price[index-1] + dp[index][len-index];
                
                int notpick=dp[index-1][len];
                
                dp[index][len]=Math.max(pick,notpick);
            }
            
        }
        return dp[n][n];
      }
}

// SPACE OPTIMIZATION
class Solution {
        public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[] prev=new int[n+1];
        
        for(int len=1;len<=n;len++)
        {
            if(1<=len) prev[len] = price[0] * ( len / 1); 
            else prev[len]=(int)-1e9;
        }
        
        for(int index=2;index<(n+1);index++)
        {
            int[] curr=new int[n+1];
            curr[0]=0;
            for(int len=1;len<(n+1);len++)
            {
                int pick=(int)-1e9;
                if(index <= len)
                pick=price[index-1] + curr[len-index];
                
                int notpick=prev[len];
                
                curr[len]=Math.max(pick,notpick);
            }
            prev=curr;
            curr=null;
        }
        return prev[n];
        }
}

/* 
Geek is learning data structures, and he recently learned about the top-down and bottom-up dynamic programming approaches. Geek is having trouble telling them apart from one another.

When given an integer n, where n is based on a 0-based index, find the nth Fibonacci number.

Every ith number in the series equals the sum of the (i-1)th and (i-2)th numbers, where the first and second numbers are specified as 0 and 1, respectively.

For the given issue, code both top-down and bottom-up approaches.

Note : As the answer might be large, return the final answer modulo 109 + 7
*/
// SOLUTION CONTAINS BOTH MEMOIZATION AND TABULAIION


class Solution {
    static long memoization(int n,long[] dp)
    {
        if(n<=1)
        {
            return n;
        }
        
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        
        return dp[n]=(memoization(n-1,dp) + memoization(n-2,dp) ) % (1000000000 +7);
    }
    
    static long tanulation(int n)
    {
        long[] table=new long[n+1];
        table[0]=0;
        table[1]=1;
        if(n<2)
        {
            return table[n];
        }
        
        for(int i=2;i<=n;i++)
        {
            table[i]=(table[i-1] + table[i-2]) % (1000000000 +7);
        }
        
        return table[n];
        
    }
    static long topDown(int n) {
        // code here
        long[] dp=new  long[n+1];
        Arrays.fill(dp,-1);
        return memoization(n,dp) % (1000000000 +7);
    }

    static long bottomUp(int n) {
        // code here
        
        return tanulation(n) % (1000000000 +7);
    }
}

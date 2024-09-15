// weekly contest  415
/*
You are given an integer array a of size 4 and another integer array b of size at least 4.

You need to choose 4 indices i0, i1, i2, and i3 from the array b such that i0 < i1 < i2 < i3. Your score will be equal to the value a[0] * b[i0] + a[1] * b[i1] + a[2] * b[i2] + a[3] * b[i3].

Return the maximum score you can achieve.

Example 1:

Input: a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]

Output: 26

Explanation:
We can choose the indices 0, 1, 2, and 5. The score will be 3 * 2 + 2 * (-6) + 5 * 4 + 6 * 2 = 26.
*/
// approach : Dynamic programming 
class Solution {
    
    public long max(int index1,int index2, int[] a,int[] b,long[][] dp)
    {  
        if(index1==a.length) return 0;
        
        if(index2==b.length  )
        {
            return(long)-1e9;
        }
        
        if(dp[index1][index2]!= (long)-1e9)
        {
            return dp[index1][index2];
        }
        
        //explore     
        long pick=a[index1] *(long)  b[index2] + max(index1+1,index2+1,a,b,dp);
        
        long nonpick=max(index1,index2+1,a,b,dp);
        
        return dp[index1][index2]=Math.max(pick,nonpick);
        
    }
    public long maxScore(int[] a, int[] b) {
        
        long[][] dp=new long[a.length+1][b.length];
        for (long[] d : dp) {
    Arrays.fill(d, (long)-1e9);
}

        return max(0,0,a,b,dp);
    }
}

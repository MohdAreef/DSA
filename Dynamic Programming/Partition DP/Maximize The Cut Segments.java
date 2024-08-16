/*
Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each 
time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Note: if no segment can be cut then return 0.

Examples:

Input: n = 4, x = 2, y = 1, z = 1
Output: 4
Explanation: Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
*/

class Solution
{
    //Function to find the maximum number of cuts.
    public int maxicut(int n,int x,int y,int z,int[] dp)
    {
       
       if(n<0) return -1;
       if(n==0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        //explore
        int cutx=maxicut(n-x,x,y,z,dp);
        int cuty=maxicut(n-y,x,y,z,dp);
        int cutz=maxicut(n-z,x,y,z,dp);
        
        
        int maxi=Math.max(cutx,Math.max(cuty,cutz));
        
        if(maxi==-1)
        {
            return dp[n]=maxi;
        }
        else
        {
         return     dp[n]=maxi+1;
        }
       
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       int res=maxicut(n,x,y,z,dp);
      if(res==-1) return 0;
      return res;
    }
}

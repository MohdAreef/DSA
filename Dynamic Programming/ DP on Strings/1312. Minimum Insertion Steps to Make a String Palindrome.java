/* 
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.
  
Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
*/

class Solution {
    public int longestPS(int index1,int index2,String s1,String s2,int[][] dp)
    {
        if(index1<0 || index2<0)
        {
            return 0;
        }

        if(dp[index1][index2]!=-1) return dp[index1][index2];


        //explore
        int pick=0;
        int nonpick=Integer.MIN_VALUE;
        if(s1.charAt(index1)==s2.charAt(index2))
        {
            pick=1+ longestPS(index1-1,index2-1,s1,s2,dp);
        }
        else
        {
            nonpick=Math.max(longestPS(index1-1,index2,s1,s2,dp),longestPS(index1,index2-1,s1,s2,dp));

        }
      return dp[index1][index2]=Math.max(pick,nonpick);
    }

    public int minInsertions(String s) {
        int n=s.length();
        StringBuffer sb=new StringBuffer(s);
        String s2=sb.reverse().toString();

        int[][] dp=new int[n+1][n+1];
        for(int[] i: dp)
        {
            Arrays.fill(i,-1);
        }

        int maxlength=longestPS(n-1,n-1,s,s2,dp);
        return n-maxlength;        
    }
}

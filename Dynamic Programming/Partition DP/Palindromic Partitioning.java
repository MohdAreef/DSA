/*
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest 
cuts needed for palindrome partitioning of the given string.

Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
*/

class Solution{
    
    static boolean isPalindrom(int i,int j,String str)
    {
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static int partition(int index,int n,String str,int[][] dp)
    {
        //base condition
        if(index==n) return 0;
        
        if(dp[index][n]!=-1) return dp[index][n];
        
        //explore
        int mini=Integer.MAX_VALUE;
        
        if(isPalindrom(index,n,str))
        {
          return 0;
        }    
                
        for(int i=index;i<=n;i++)
        {
            if(isPalindrom(index,i,str))
            {
                mini=Math.min(mini,1+partition(i+1,n,str,dp));
            }
        }
        
        return dp[index][n]=mini;
    }
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        int[][] dp=new int[n][n];
        for(int[] i:dp)
        {
            Arrays.fill(i,-1);
        }
        
        return partition(0,n-1,str,dp);
        
    }
}

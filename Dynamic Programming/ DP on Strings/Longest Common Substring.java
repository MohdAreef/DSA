// Given two strings. The task is to find the length of the longest common substring.


//TABULATION 
class Solution{
    int tabulation(String s1,String s2)
    {
        int i,j;
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(i=0;i<(m+1);i++)
        {
            dp[0][i]=0;
        }
        for(i=0;i<(n+1);i++)
        {
            dp[i][0]=0;
        }
        int maxi=Integer.MIN_VALUE;
        
        for(i=1;i<(n+1);i++)
        {
            for(j=1;j<(m+1);j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                dp[i][j]=0;
                maxi=Math.max(maxi,dp[i][j]);
            }
        }
        return maxi;
        
    }
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        return tabulation(s1,s2);
    }
}

//SPACE OPTIMIZATION
class Solution{
    int tabulation(String s1,String s2)
    {
        int i,j;
        int n=s1.length();
        int m=s2.length();
        // int[][] dp=new int[n+1][m+1];
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(i=0;i<(m+1);i++)
        {
            prev[i]=0;
            curr[i]=0;
            
        }
      
        int maxi=Integer.MIN_VALUE;
        
        for(i=1;i<(n+1);i++)
        {
            for(j=1;j<(m+1);j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    curr[j]=1+prev[j-1];
                }
                else
                curr[j]=0;
                maxi=Math.max(maxi,curr[j]);
            }
            prev=curr.clone();
        }
        return maxi;
        
    }
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        return tabulation(s1,s2);
    }
}



// TABULATION SOLUTION

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][3];
     
        
    for(int j=0;j<3;j++)
    {
        int maxi=0;
        for(int i=0;i<3;i++)
        {
            if(i!=j)
            {
                maxi=Math.max(maxi,arr[0][i]);
            }
        }
        dp[0][j]=maxi;
    }   
        for(int day=1;day<n;day++)
        {
            for(int last=0;last<3;last++)
            {
                int maxpoints=0;
                
                for(int i=0;i<3;i++)
                {
                    if(i!=last)
                    {
                        maxpoints=Math.max(maxpoints,dp[day-1][i]+arr[day][i]);
                    }
                }
                
                dp[day][last]=maxpoints;
            }
        }
        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
     
    }
}

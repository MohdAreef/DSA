// MATRIX CHAIN MULTIPLICATION USING TABULITON METHOD

static int tabulation(int n, int[] arr)
    {
       int i,j;
        int[][] dp=new int[n][n];
        //base case
        for(i=1;i<n;i++)
        {
            dp[i][i]=0;
        }
        
        for( i=n-1;i>0;i--)
        {
            for( j=i+1;j<=n-1;j++)
            {
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++)
                {
                    int steps=arr[i-1] * arr[k] * arr[j] + dp[i][k]+ dp[k+1][j];
                    mini=Math.min(mini,steps);
                }
                 dp[i][j]=mini;
            }
        }
        return dp[1][n-1];
    }
    static int matrixMultiplication(int N, int arr[])
    {
       return tabulation(N,arr);
    }
}

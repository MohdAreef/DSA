/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the 
bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
*/

class Solution {
    public int unique(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        int up = unique(m - 1, n, dp);
        int down = unique(m, n - 1, dp);

        return dp[m][n] = up + down;

    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        return unique(m - 1, n - 1, dp);
    }
}


******************************************************************************************************************




//ANOTHER SOLUTION
class Solution {
 public int totalpaths(int r,int c,int m,int n,int[][] dp)
  {
    //base condition
    if(r==m && c==n) return 1;


    //explore
    int rows[]={1,0};
    int cols[]={0,1};
    int total=0;
    if(dp[r][c]!=-1) return dp[r][c];
    for(int i=0;i<2;i++)
    {
        int newrow=r+rows[i];
        int newcol=c+cols[i];

        

        if(newrow>=0 && newrow<=m && newcol>=0 && newcol<=n )
        {
          int a=totalpaths(newrow,newcol,m,n,dp);
          total=total+a;
        }
    }
    return dp[r][c]=total;
  }
 public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        // return unique(m - 1, n - 1, dp);
        boolean[][] vis=new boolean[m][n];
        for(boolean[] b:vis)
        {
            Arrays.fill(b,false);
        }
        return totalpaths(0,0,m-1,n-1,dp);
    }
}

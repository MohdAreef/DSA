/*
You are given an n rows and m cols matrix grid representing a field of chocolates where grid[i][j] represents the number of chocolates that you can 
collect from the (i, j) cell.

You have two robots that can collect chocolates for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of chocolates collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the chocolates.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
  */



class Solution {
    public int findmaxsum(int i,int j1,int j2,int [][] grid,int n,int m,int[][][] dp)
    {
        //base cases
        
        if(j1<0 || j1>(m-1) || j2<0 || j2>(m-1))
        {
            return (int)-1e9;
        }
        
        if(i==n-1)
        {
            if(j1==j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2]!=-1)
        {
            return dp[i][j1][j2];
        }
        
        
        // explore all the paths
        int paths[]={-1,0,1};
        int maxi=0;
        for(int c1=0;c1<3;c1++)
        {   
            for(int c2=0;c2<3;c2++)
            {
                if(j1 == j2)
                {
                    maxi=Math.max(maxi,grid[i][j1] + findmaxsum(i+1,j1+paths[c1],j2+paths[c2],grid,n,m,dp));
                }
                else
                {
                    maxi=Math.max(maxi,grid[i][j1] + grid[i][j2] + findmaxsum(i+1,j1+paths[c1],j2+paths[c2],grid,n,m,dp));
                }
            }
        }
        
        return dp[i][j1][j2]=maxi;
    }
    
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return findmaxsum(0,0,m-1,grid,n,m,dp);
        
        
    }
}

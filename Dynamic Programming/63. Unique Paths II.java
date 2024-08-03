//FOLLOWUP PROBLEM FOR UNIQUE PATHS

/* You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move 
to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
*/


class Solution {
    public int unique(int m, int n, int[][] grid, int[][] dp) {

        if (m < 0 || n < 0)
            return 0;
        if (grid[m][n] == 1) {
            return 0;
        }

        if (m == 0 && n == 0)
            return 1;

        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = unique(m - 1, n, grid, dp);
        int down = unique(m, n - 1, grid, dp);

        return dp[m][n] = up + down;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return unique(m - 1, n - 1, obstacleGrid, dp);
    }
}


********************************************************************************************************************
    //ANOTHER SOLUTION
    
    class Solution {
    public int totalpaths(int r, int c, int m, int n, int[][] dp, int[][] obstacle) {
        // base condition
        if (r == m && c == n && obstacle[r][c] == 0)
            return 1;

        if (r == m && c == n && obstacle[r][c] == 1)
            return 0;

        if (obstacle[r][c] == 1)
            return 0;
        // explore
        int rows[] = { 1, 0 };
        int cols[] = { 0, 1 };
        int total = 0;
        if (dp[r][c] != -1)
            return dp[r][c];
        for (int i = 0; i < 2; i++) {
            int newrow = r + rows[i];
            int newcol = c + cols[i];

            if (newrow >= 0 && newrow <= m && newcol >= 0 && newcol <= n && obstacle[newrow][newcol] == 0) {
                int a = totalpaths(newrow, newcol, m, n, dp, obstacle);
                total = total + a;
            }
        }
        return dp[r][c] = total;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return totalpaths(0, 0, m - 1, n - 1, dp, obstacleGrid);
    }
}

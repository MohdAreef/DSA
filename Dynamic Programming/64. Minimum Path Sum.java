/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
*/

class Solution {
    public int minpath(int m, int n, int[][] grid, int[][] dp) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int up = (m - 1) > -1 ? grid[m][n] + minpath(m - 1, n, grid, dp) : Integer.MAX_VALUE;
        int left = (n - 1) > -1 ? grid[m][n] + minpath(m, n - 1, grid, dp) : Integer.MAX_VALUE;

        return dp[m][n] = Math.min(up, left);

    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return minpath(m - 1, n - 1, grid, dp);

    }
}

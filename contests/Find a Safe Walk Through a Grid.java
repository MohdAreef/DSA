// Biweekly Contest 139
/*
You are given an m x n binary matrix grid and an integer health.

You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).

You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.

Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.

Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.

Example 1:

Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

Output: true

Explanation:

The final cell can be reached safely by walking along the gray cells below.
*/

class Solution {

    public boolean find(int i, int j, List<List<Integer>> grid, int health, boolean[][] vis, int[][][] dp) {
        int m = grid.size();
        int n = grid.get(0).size();
        // base condition

        if (i == (m - 1) && j == (n - 1)) {
            if (health >= 1) {
                return true;
            }

            else
                return false;
        }

        if (dp[i][j][health] != -1) {
            if (dp[i][j][health] == 1)
                return true;
            return false;
        }

        int[] rows = { 0, 1, 0, -1 };

        int[] cols = { -1, 0, 1, 0 };

        for (int k = 0; k < 4; k++) {
            int newrow = i + rows[k];
            int newcol = j + cols[k];

            if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && vis[newrow][newcol] == false) {
                vis[newrow][newcol] = true;
                if (grid.get(newrow).get(newcol) == 1) {

                    if (health >= 2 && find(newrow, newcol, grid, health - 1, vis, dp) == true) {
                        dp[i][j][health] = 1;
                        return true;
                    }

                } else {
                    if (health >= 1 && find(newrow, newcol, grid, health, vis, dp) == true) {
                        dp[i][j][health] = 1;
                        return true;
                    }
                }

                vis[newrow][newcol] = false;
            }
        }
        dp[i][j][health] = 0;
        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][][] dp = new int[m + 1][n + 1][health + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < health + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        boolean[][] vis = new boolean[m][n];
        for (boolean[] b : vis) {
            Arrays.fill(b, false);
        }
        vis[0][0] = true;
        if (grid.get(0).get(0) == 1)
            health -= 1;
        return find(0, 0, grid, health, vis, dp);

    }
}


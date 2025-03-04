// Tabulation solution
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[m - 1][n - 1] == 1 || grid[0][0] == 1)
            return 0;
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1)
                break;

            else
                dp[0][i] = 1;

        }

        for (int j = 0; j < m; j++) {
            dp[j][0] = 0;
        }

        for (int j = 0; j < m; j++) {
            if (grid[j][0] == 1)
                break;
            else
                dp[j][0] = 1;
        }

        int[] rows = new int[] { -1, 0 };
        int[] cols = new int[] { 0, -1 };

        for (int row = 1; row < m; row++) {

            for (int col = 1; col < n; col++) {
                int sum = 0;
                if (grid[row][col] == 1)
                    dp[row][col] = 0;
                else {

                    for (int i = 0; i < 2; i++) {
                        int newrow = row + rows[i];
                        int newcol = col + cols[i];
                        if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && grid[newrow][newcol] == 0) {
                            sum += dp[newrow][newcol];
                        }
                    }
                    dp[row][col] = sum;

                }
            }
        }

        return dp[m - 1][n - 1];

    }

}

// TABULATION
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        int[] rows = new int[] { -1, 0 };
        int[] cols = new int[] { 0, -1 };

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                int sum = 0;
                for (int i = 0; i < 2; i++) {
                    int newrow = row + rows[i];
                    int newcol = col + cols[i];
                    if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n) {
                        sum += dp[newrow][newcol];
                    }
                }
                dp[row][col] = sum;
            }
        }
        return dp[m - 1][n - 1];

    }
}


// SPACE OPTIMIZATION
class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];

        int[] prevrow = new int[n];
        for (int i = 0; i < n; i++)
            prevrow[i] = 1;

        // int[] currow=new int[n];
        // currrow[0]=1;

        // for (int i = 0; i < m; i++)
        // dp[i][0] = 1;

        // for (int j = 0; j < n; j++)
        // dp[0][j] = 1;

        int[] rows = new int[] { -1, 0 };
        int[] cols = new int[] { 0, -1 };

        for (int row = 1; row < m; row++) {
            int[] currrow = new int[n];
            currrow[0] = 1;
            for (int col = 1; col < n; col++) {
                int sum = 0;
                // for (int i = 0; i < 2; i++) {
                // int newrow = row + rows[i];
                // int newcol = col + cols[i];
                // if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n) {
                // sum += dp[newrow][newcol];
                // }
                // }

                sum = prevrow[col] + currrow[col - 1];
                currrow[col] = sum;

                // dp[row][col] = sum;
            }

            prevrow = currrow;
            currrow = null;
        }
        return prevrow[n - 1];

    }
}

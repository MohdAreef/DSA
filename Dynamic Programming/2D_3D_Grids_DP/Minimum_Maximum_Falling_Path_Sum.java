// TABULATION SOLUTION
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int above_left = Integer.MAX_VALUE;
                int above = Integer.MAX_VALUE;
                int above_right = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    above_left = matrix[i][j] + dp[i - 1][j - 1];
                }
                above = matrix[i][j] + dp[i - 1][j];

                if (j + 1 < n)
                    above_right = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(above_left, Math.min(above, above_right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}

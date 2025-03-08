/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
*/
// MEMOIZATION
class Solution {
    public int totalcombo(int index, int target, int[] coins, int[][] dp) {

        if (index == 0) {
            if (target % coins[index] == 0)
                return 1;
            return 0;

        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int nonpick = totalcombo(index - 1, target, coins, dp);
        int pick = 0;
        if (target >= coins[index]) {
            pick = totalcombo(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = pick + nonpick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return totalcombo(n - 1, amount, coins, dp);
    }
}
// TABULATION
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                dp[0][amt] = 1;
            else
                dp[0][amt] = 0;
        }

        for (int index = 1; index < n; index++) {

            for (int amt = 0; amt <= amount; amt++) {
                int pick = 0;
                if (coins[index] <= amt)
                    pick = dp[index][amt - coins[index]];

                int notpick = dp[index - 1][amt];

                dp[index][amt] = pick + notpick;
            }
        }
        return dp[n - 1][amount];
    }
}

// SPACE OPTIMIZATION
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                prev[amt] = 1;
            else
                prev[amt] = 0;
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {
                int pick = 0;
                if (coins[index] <= amt)
                    pick = curr[amt - coins[index]];

                int notpick = prev[amt];

                curr[amt] = pick + notpick;
            }
            prev = curr;
            curr = null;
        }
        return prev[amount];
    }
}

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/
class Solution {
    public int min(int index1, int index2, String s1, String s2, int[][] dp) {
        // base condtions
        if (index1 < 0)
            return index2 + 1;
        if (index2 < 0)
            return index1 + 1;

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // explore
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = min(index1 - 1, index2 - 1, s1, s2, dp);
        }

        int a = 1 + min(index1, index2 - 1, s1, s2, dp); // insertion
        int b = 1 + min(index1 - 1, index2, s1, s2, dp); // deletion
        int c = 1 + min(index1 - 1, index2 - 1, s1, s2, dp); // replace
        return dp[index1][index2] = Math.min(a, Math.min(b, c));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return min(m - 1, n - 1, word1, word2, dp);

    }
}

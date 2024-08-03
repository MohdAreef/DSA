/*
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters 
to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, 
and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
*/

class Solution {

    public boolean compare(String s1, String s2) {

        if ((s2.length() + 1) == s1.length()) {
            int j = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {

                    j++;
                }

            }
            if (j == s2.length())
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public int longest(String[] words) {
        int i, j;
        int n = words.length;
        int maxi = 1;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (compare(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    maxi = Math.max(maxi, dp[i]);

                }
            }
        }
        return maxi;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        return longest(words);
    }
}

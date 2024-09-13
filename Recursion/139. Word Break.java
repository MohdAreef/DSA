/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
*/

class Solution {
    public boolean check(int index, String s, HashSet<String> wordDict, int[] dp) {
        int n = s.length();
        // base condition
        if (index == n) {
            return true;
        }
        if (dp[index] != -1) {
            return dp[index] == 0 ? false : true;
        }
        for (int i = index; i < n + 1; i++) {
            String sub = s.substring(index, i);
            if (wordDict.contains(sub)) {
                System.out.println("match" + i);
                if (check(i, s, wordDict, dp) == true) {
                    dp[index] = 1;
                    return true;
                }
            }
        }
        dp[index] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }

        return check(0, s, set, dp);
    }
}

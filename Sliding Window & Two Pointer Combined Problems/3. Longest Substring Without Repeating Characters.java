/*
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/
class Solution {
    public int length(String s) {
        int n = s.length();
        int l = 0, r = 0, count = 0;
        int maxi = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            while (map.get(c) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxi = Math.max(maxi, r - l + 1);
            r++;
        }
        return maxi;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = length(s);
        if (n == Integer.MIN_VALUE)
            return 0;
        else
            return n;
    }
}

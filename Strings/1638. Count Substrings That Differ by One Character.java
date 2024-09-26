/*
Given two strings s and t, find the number of ways you can choose a non-empty substring of s and replace a single character by a different character 
such that the resulting substring is a substring of t. In other words, find the number of substrings in s that differ from some substring in t by 
exactly one character.

For example, the underlined substrings in "computer" and "computation" only differ by the 'e'/'a', so this is a valid way.

Return the number of substrings that satisfy the condition above.

A substring is a contiguous sequence of characters within a string.
*/

class Solution {
    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int x = i;
                int y = j;
                int d = 0;
                while (x < s.length() && y < t.length()) {
                    if (s.charAt(x) != t.charAt(y))
                        d++;
                    if (d == 1)
                        count++;
                    if (d == 2)
                        break;
                    x++;
                    y++;
                }
            }
        }
        return count;
    }
}

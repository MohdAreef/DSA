/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
*/

class Solution {
    public boolean rotate(String s, String goal) {
        char c = goal.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.equals(goal))
                    return true;
            }
        }
        return false;
    }

    public boolean rotateString(String s, String goal) {
        return rotate(s, goal);
    }
}

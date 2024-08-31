/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
*/
class Solution {

    public boolean check(String s, String t) {
        int m = s.length();

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> vismap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }

            } else {
                if (vismap.containsKey(t.charAt(i)))
                    return false;

                map.put(s.charAt(i), t.charAt(i));
                vismap.put(t.charAt(i), true);

            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        return check(s, t);
    }
}

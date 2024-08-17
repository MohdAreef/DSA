/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.
*/

class Solution {
    public int minimum(String s) {
        // Stack<Character> stack=new Stack<>();
        int cnt = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // stack.push('(');
                open++;
            } else {
                if (open == 0) {
                    cnt++;
                } else {
                    // stack.pop();
                    open--;
                }
            }
        }
        return open + cnt;
    }

    public int minAddToMakeValid(String s) {
        return minimum(s);

    }
}

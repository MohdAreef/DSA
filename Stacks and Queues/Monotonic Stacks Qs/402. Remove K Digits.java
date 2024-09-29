/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
*/

class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int a = Integer.parseInt(num.charAt(i) + "");
            while (!stack.isEmpty() && stack.peek() > a && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(a);
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String ans = sb.reverse().toString();
        if (k != 0 && sb.substring(0, sb.length() - k).equals(""))
            return "0";

        String s = sb.substring(0, sb.length() - k);
        int j = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                j = i;
                break;
            }
        }
        if (j == -1)
            return "0";
        return s.substring(j);
    }
}

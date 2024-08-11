/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits 
were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, 
integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.
*/
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        StringBuffer sb = new StringBuffer("");
        int flag = 0;
        int i, j;
        for (i = 0; i < n; i++) {
            if (flag == 0 && s.charAt(i) == '+')
                flag = 1;
            else if (flag == 0 && (s.charAt(i) == '-')) {
                flag = 2;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (flag == 0) {
                    flag = 1;
                }
                sb.append(s.charAt(i));
            } else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    || Character.toString(s.charAt(i)).matches("[+-/*.,\\s]")) {
                break;
            }
        }

        if (sb.length() == 0) {
            return 0;
        }
        double res = Double.parseDouble(sb.toString());
        if (flag == 2) {
            res = -1 * res;
        }
        if (res > (2e31 - 1)) {
            res = 2e31 - 1;
        }
        if (res < -(2e31)) {
            res = -2e31;
        }
        return (int) res;

    }
}

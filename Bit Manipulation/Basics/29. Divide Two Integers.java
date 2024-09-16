/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 
would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this 
problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
*/

class Solution {
    long[] dp = new long[10000];

    public int findHighestPowerDivisible(long a, long b) {
        int i = 0;
        long temp = b;
        while (temp <= a) {
            if (dp[i] != 0) {
                temp = b * dp[i];
            } else {
                long ans = (long) Math.pow(2, i);
                dp[i] = ans;
                temp = b * ans;

            }
            i++;
        }
        return i - 2;
    }

    public int divideFunction(long dividend, long divisor) {

        int ans = 0;
        while (dividend >= divisor) {
            int power = findHighestPowerDivisible(dividend, divisor);

            long temp = (long) Math.pow(2, power);
            dividend = (int) (dividend - (long) divisor * temp);
            ans += (int) temp;
        }
        return ans;
    }

    public int divide(long dividend, long divisor) {
        if (dividend == divisor)
            return 1;
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        boolean sign = false;
        long a = dividend, b = divisor;

        // make the numbers positive
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = true;
        }

        a = Math.abs(a);
        b = Math.abs(b);
        Arrays.fill(dp, 0);

        int ans = divideFunction(a, b);

        // change the sign of the answer based on flags
        if (sign == true) {
            return -1 * ans;
        } else {
            return ans;
        }

    }
}

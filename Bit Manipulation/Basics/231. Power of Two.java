/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        int pow = (int) Math.ceil((long) (Math.log(n) / Math.log(2)));
        System.out.println(pow);
        if ((int) Math.pow(2, pow) == n)
            return true;
        return false;

    }
}

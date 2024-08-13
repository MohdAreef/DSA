/*
A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, 
"3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
*/
class Solution {

    //count function is a recursive implementation gives TLE with large test cases 
    public int count(long index, long n, String sb, int[] evens, int[] primes) {
        // if(index>n) return 0;
        if (index == (n)) {
            return 1;
        }
        // explore
        int sum = 0;
        if (index % 2 == 0) {
            for (int i = 0; i < evens.length; i++) {
                sum += count(index + 1, n, sb + evens[i], evens, primes);
            }

        } else {
            for (int i = 0; i < primes.length; i++) {
                sum += count(index + 1, n, sb + primes[i], evens, primes);
            }

        }

        return sum;
    }
    //implementing power function because in-built power function does n't apply module , ans might overflow 
    public int power(int x, long y) {
        // base condition
        int mod = (int) (1e9 + 7);

        if (y == 0) {
            return 1;
        }
        if (y == 1)
            return x;

        // explore
        int res = 0;
        if (y % 2 == 0) {
            res = (int) (((long) power(x, y / 2)) % mod);
            return (int) (((long) res * (long) res) % mod);

        } else {
            res = (int) (((long) power(x, y / 2)) % mod);
            res = (int) ((((long) res) * ((long) res)) % mod);
            res = (int) ((((long) res * (long) power(x, 1))) % mod);
            return res % mod;
        }
    }

    public int countways(long n) {
        long even = (n / 2) + (n % 2);
        long odd = n / 2;
        int mod = (int) (1e9 + 7);

        int res = (int) ((long) power(5, even) % mod);
        res = (int) (((long) res * (long) power(4, odd)) % mod);

        return res;

    }

    public int countGoodNumbers(long n) {

        // return count(0,n,new String(),new int[]{0,2,4,6,8},new int[]{2,3,5,7});
        return countways(n);
    }
}

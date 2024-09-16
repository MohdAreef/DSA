/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

class Solution {
    public int Sieve(int n, boolean[] primes) {
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == true) {
                for (int k = i * i; k < n; k = k + i) {
                    primes[k] = false;
                }
            }
        }
        int cnt = 0;
        // System.out.println(Arrays.toString(primes));
        for (int i = 2; i < n; i++) {
            if (primes[i] == true)
                cnt++;
        }
        return cnt;
    }

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        if (n < 3)
            return 0;
        return Sieve(n, primes);
    }
}

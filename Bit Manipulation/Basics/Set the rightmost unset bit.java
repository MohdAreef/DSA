/*
Given a non-negative number n . The problem is to set the rightmost unset bit in the binary representation of n.

Examples :

Input: n = 6
Output: 7
Explanation: The binary representation of 6 is 110. After setting right most bit it becomes 111 which is 7.
*/

class Solution {
    static int set(int n)
    {
        int noofbits=(int)((double)Math.log(n)/Math.log(2));
        int i=0;
        for( i=0;i<=noofbits;i++)
        {
            if((n&(1<<i))==0)
            {
                return n|(1<<i);
            }
        }
        // System.out.println(n+" "+(1<<i));
        return n|(1<<i);
    }
    static int setBit(int n) {
        // code here
        return set(n);
    }
}

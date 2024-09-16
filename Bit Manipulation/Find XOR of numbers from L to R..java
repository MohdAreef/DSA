/*
You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].

Example:

Input: 
L = 4, R = 8 
Output:
8 
Explanation:
4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
*/


class Solution {
    public static int findNthXOR(int n)
    {
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        
        else if(n%4==0) return n;
        
        return 0;
    }
    public static int findXOR(int l, int r) {
        
        
        int nthxor=findNthXOR(r);
        int lthxor=findNthXOR(l-1);
        return nthxor^lthxor;
    }
}

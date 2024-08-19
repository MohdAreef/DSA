/*
There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 
Example 1:

Input: n = 3
Output: 3
Explanation: Initially, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
*/

class Solution {
   
    public int minimum(int n)
    {
          if(n==1) return 0;
          if(n==2) return 2;

          int[] dp=new int[n+1];
          dp[1]=0;
          dp[2]=2;
          for(int i=3;i<(n+1);i++)
          {
            int j=i/2;
            dp[i]=i;
            while(j>1)
            {
                if(i%j==0)
                {
                dp[i]=Math.min(dp[i],dp[j] + i/j);
                // break;
                }
                j--;
            }
          }
          return dp[n];

    }
    public int minSteps(int n) {
      
        return minimum(n);
       
        
    }
}

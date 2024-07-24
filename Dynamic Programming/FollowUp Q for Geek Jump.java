/*
There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone, 
where k is the maximum number of steps that can be jumped and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum 
possible total cost incurred before the Geek reaches Stone n.
Examples :
Input: n = 5, k = 3 heights = {10, 30, 40, 50, 20}
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
  */

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int memoization(int arr[],int n,int k,int[] dp)
    {
        if(n==0)
        {
            return 0;
        }
        
        if(dp[n]!=Integer.MAX_VALUE)
        {
            return dp[n];
        }
        
        
        for(int i=1;i<=k;i++)
        {
            if(n-i >=0)
            {
                    
            int a=memoization(arr,n-i,k,dp); 
            int b= a + Math.abs(arr[n]-arr[n-i]);
            dp[n]=Math.min(b,dp[n]);
                
            }
            
        }
        
        return dp[n];
        
    }
    public int minimizeCost(int arr[], int N, int K) {
        // code here
        
        int[] dp=new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE);
      
        // System.out.println(Arrays.toString(dp));
        return memoization(arr,N-1,K,dp);
        // return 1;
        
    }
}

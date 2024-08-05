/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least 
number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions 
(arr[i-1] x arr[i]).

Example 1:

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explanation: There are 4 matrices of dimension 
40x20, 20x30, 30x10, 10x30. Say the matrices are 
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D. 
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.
*/

class Solution{
    static int matrix(int i,int j,int n,int[] arr,int[][] dp)
    {
        //base condition
        if(i==j)
        return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        //explore
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int steps=arr[i-1] * arr[k] * arr[j] + matrix(i,k,n,arr,dp) + matrix(k+1,j,n,arr,dp);
            mini=Math.min(mini,steps);
        }
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp=new int[N][N];
        for(int[] i: dp)
        {
            
        Arrays.fill(i,-1);
        }
       return   matrix(1,N-1,N,arr,dp);
    }
}

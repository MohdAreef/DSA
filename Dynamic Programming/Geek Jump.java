/*
Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, 
the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

Example:
Input:
n = 4
height = {10 20 30 10}
Output:
20
Explanation:
Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
so, total energy lost is 20 which is the minimum.
*/
// SOLUTION CONTAINS MEMOIZATION , TABULAITON AND SPACE OPTIMIZED SOLUTION

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minEnergy(int arr[],int N,int dp[])
    {
        if(N==0)
        {
            return 0;
        }
        if(N==1)
        {
            return Math.abs(arr[1]-arr[0]);
        }
        
        if(dp[N]!=-1)
        {
            return dp[N];
        }
        
        int left=minEnergy(arr,N-1,dp)+ Math.abs(arr[N]-arr[N-1]);
        
        int right=minEnergy(arr,N-2,dp) + Math.abs(arr[N]-arr[N-2]);
        
        dp[N]=Math.min(left,right);
        
        return dp[N];
        
    }
    
    public int tabulation(int arr[],int n)
    {
        int table[]=new int[n];
        int i;
        table[0]=0;
        if(n==1)  return table[n-1];
        
        table[1]=Math.abs(arr[0]-arr[1]);
        if(n==2) return table[n-1]; 
        
       
        for( i=2;i<n;i++)
        {
            int a= table[i-1] + Math.abs(arr[i-1]-arr[i]);
            int b=table[i-2] + Math.abs(arr[i-2]-arr[i]);
            
            table[i]=Math.min(a,b);
        }
       
        
       return table[n-1];
        
    }
    
    public int spaceoptimized(int arr[],int n)
    {
        int curr=0;
        int prev2=0;
        if(n-1==0) return prev2;
        int prev1=Math.abs(arr[0]-arr[1]);
        if(n-1==1) return prev1;
        for(int i=2;i<n;i++)
        {
            int a= prev1 + Math.abs(arr[i-1]-arr[i]);
            
            int b=prev2 + Math.abs(arr[i-2]-arr[i]);
            
           curr=Math.min(a,b);
           
           prev2=prev1;
           prev1=curr;
        }
        return prev1;
    }
    public int minimumEnergy(int arr[],int N){
        //code here
        
        // int[] dp=new int[N];
        // Arrays.fill(dp,-1);
        // return minEnergy(arr,N-1,dp);
        // return tabulation( arr, N);
     return   spaceoptimized(arr,N);
    }
}

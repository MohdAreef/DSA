/*
Given an integer n and an array of integers arr, return the Longest Increasing Subsequence which is Index-wise lexicographically smallest.
Note - A subsequence S1 is Index-wise lexicographically smaller than a subsequence S2 if in the first position where S1 and S2 differ, 
subsequence S1 has an element that appears earlier in the array  arr than the corresponding element in S2.
LIS  of a given sequence is defined as that longest possible subsequence all of whose elements are in increasing order. For example, 
the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and the LIS is {10, 22, 33, 50, 60, 80}. 
*/

class Solution {
    public ArrayList<Integer> longest(int n,int arr[])
    {
        // int n=arr.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        int i,j;
        Arrays.fill(dp,1);
        for(i=0;i<n;i++)
        {
            parent[i]=i;
        }
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                {
                    // dp[i]=Math.max(dp[i],1+dp[j]);
                    if(1+dp[j]>dp[i])
                    {
                        dp[i]=1+dp[j];
                        parent[i]=j;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int index=0;
        int max=dp[0];
        for(i=1;i<n;i++)
        {
            if(max<dp[i])
            {
                max=dp[i];
                index=i;
            }
        }
      ArrayList<Integer> res=new ArrayList<>();
        while(index!=parent[index])
        {
          res.add(arr[index]);
          index=parent[index];
        }
        res.add(arr[index]);
        Collections.reverse(res);
        return res;
    }
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        
        return  longest(n,arr);
    }
}

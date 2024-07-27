/* 
Given an array arr, partition it into two subsets(possibly empty) such that each element must belong to only one subset. Let the sum of the elements 
of these two subsets be S1 and S2. 
Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference between S1 and S2 is equal to d.
Since the answer may be large return it modulo 109 + 7.
*/

class Solution {
    public static int count(int index,int sum,int[] arr,int[][] dp)
    {
        if(index==0)
        {
            if(sum==0 && arr[index]==0) return 2;
            if(sum==0) return 1;
            if(sum==arr[index]) return 1;
            return 0;
        }
        if(sum<0) return 0;
        
        if(dp[index][sum]!=-1)
        {
            return dp[index][sum];
        }
        
        
        int nonpick=count(index-1,sum,arr,dp) % (int)(1e9+7);
        int pick=0;
        if(sum>=arr[index])
        {
        pick=count(index-1,sum-arr[index],arr,dp) % (int)(1e9+7);
        }
        
        return dp[index][sum]=(pick+nonpick) % (int)(1e9+7);
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        
        int i,j,sum=0;
        for(i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        int diff=sum-d;
        if(diff%2!=0) return 0;
        int k= diff / 2;
        // System.out.println("kvaue"+k);
        if(k<0) return 0;
        int[][] dp=new int[n][k+1];
        for(i=0;i<n;i++)
        {
            for(j=0;j<=k;j++)
            {
                dp[i][j]=-1;
            }
        }
      
            return count(n-1,k,arr,dp)% (int) (1e9+7);
    }
}
        

// Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
class Solution{
    
    static Boolean issumexists(int index,int sum,int[] arr,int[][] dp)
    {
        //base case
        if(sum==0)
        {
            return true;
        }
        if(index<0)
        {
            return false;
        }
        
        if(dp[index][sum]!=-1)
        {
            return dp[index][sum]==1 ? true : false;
        }
        //explore
        Boolean pick=false;
        if(sum >= arr[index])
        {
         pick=issumexists(index-1,sum-arr[index],arr,dp);
            
        }
        Boolean nonpick=issumexists(index-1,sum,arr,dp);
        
       Boolean temp=pick || nonpick;
       if(temp==true)  dp[index][sum]=1 ;
       else dp[index][sum]=0;
       
       return pick || nonpick;
    }


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp=new  int[101][10000+1];
        
        for(int i=0;i<101;i++)
        {
            for(int j=0;j<10000+1;j++)
            {
                
            dp[i][j]=-1;
            }
        }
        
        return issumexists(N-1,sum,arr,dp);
    }
}
// TABULAIION 
class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n=arr.length;
        boolean[][] dp=new boolean[n][target+1];
        
        for(int tar=0;tar<=target;tar++)
        {
            if(tar==arr[0])  dp[0][tar]=true;
            else 
            dp[0][tar]=false;
        }
        
        for(int index=0;index<n;index++)
        {
            dp[index][0]=true;
        }
        
        for(int index=1;index<n;index++)
        {
            for(int tar=1;tar<=target;tar++)
            {
                boolean pick=false;
                if(tar-arr[index]>=0)
                pick=dp[index-1][tar-arr[index]];
                
                boolean  nonpick=dp[index-1][tar];
                
                dp[index][tar] = pick || nonpick;
                
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(dp[i][target]==true) return true;
        }
        return false;
        
    }
}

//SPACE OPTIMIZATION
class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n=arr.length;
        boolean[] prev=new boolean[target+1];
        for(int tar=0;tar<=target;tar++)
        {
            if(tar==arr[0]) prev[tar]=true;
            else 
            prev[tar]=false;
            
        }
     
        prev[0]=true;
        for(int index=1;index<n;index++)
        {
            boolean[] curr=new boolean[target+1];
            curr[0]=true;
            
            for(int tar=1;tar<=target;tar++)
            {
                boolean pick=false;
                if(tar-arr[index]>=0)
                pick=prev[tar-arr[index]];
                
                boolean  nonpick=prev[tar];
                
                curr[tar] = pick || nonpick;
                
            }
            
            prev=curr;
            curr=null;
        }
        for(int i=0;i<n;i++)
        {
            if(prev[target]==true) return true;
        }
        return false;
    }
}

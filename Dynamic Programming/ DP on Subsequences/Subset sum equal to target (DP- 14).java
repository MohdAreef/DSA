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

//INFINITE SUPPLY OF OBJECTS
/*
Given a set of N items, each with a weight and a value, represented by the array w and val respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times. 
*/
// MEMOIZATION
class Solution{
    static int maxprofit(int index,int weight,int[] val,int[] wt,int[][] dp)
    {
        //base conditions
        if(index==0)
        {
    
                return (weight/wt[0]) * val[0];
        }
        
        if(dp[index][weight]!=-1) return dp[index][weight];
        
        int nonpick=maxprofit(index-1,weight,val,wt,dp);
        
        int pick=(int) -1e9;
        
        if(weight>=wt[index])
        {
        pick=val[index] + maxprofit(index,weight-wt[index],val,wt,dp);
            
        }
        
        return dp[index][weight]=Math.max(pick,nonpick);
    }
    
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
       int[][] dp=new int[N][W+1];
       for(int[] i:dp)
       {
           Arrays.fill(i,-1);
       }
       int res=maxprofit(N-1,W,val,wt,dp);
       if(res==(int)-1e9) return 0;
       return res;
    }
}
// TABULATION
class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][capacity+1];
        
        for(int cap=0;cap<=capacity;cap++)
        {
                dp[0][cap]=(cap/wt[0]) * val[0];
        }
        
        for(int index=1;index<n;index++)
        {
            for(int cap=0;cap<=capacity;cap++)
            {
                int pick=(int)-1e9;
                if(wt[index] <=cap)
                {
                    pick=val[index] +dp[index][cap-wt[index]];
                }
                
            int   notpick=dp[index-1][cap];
                
                dp[index][cap]=Math.max(pick,notpick);
            }
        }
        
        return dp[n-1][capacity];
    }
}
// SPACE OPTIMIZATION
class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
    
        int[] prev=new int[capacity+1];
        for(int cap=0;cap<=capacity;cap++)
        {
                prev[cap]=(cap/wt[0]) * val[0];
        }
        
        for(int index=1;index<n;index++)
        {
            int[] curr=new int[capacity+1];
            
            for(int cap=0;cap<=capacity;cap++)
            {
                int pick=(int)-1e9;
                if(wt[index] <=cap)
                {
                    pick=val[index] +curr[cap-wt[index]];
                }
                
               int notpick=prev[cap];
                
               curr[cap]=Math.max(pick,notpick);
            }
            prev=curr;
            curr=null;
        }
        
        return prev[capacity];
    }
}

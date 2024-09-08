/*
Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array 
of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint 
continuous boards, say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.

Example 1:

Input:
n = 5
k = 3
arr[] = {5,10,30,20,15}
Output: 35
Explanation: The most optimal way will be:
Painter 1 allocation : {5,10}
Painter 2 allocation : {30}
Painter 3 allocation : {20,15}
Job will be done when all painters finish
i.e. at time = max(5+10, 30, 20+15) = 35
*/

class Solution{
     static int allocate(long mid,int[] arr)
     {
         int  cnt=1;
         long sum=0;
         for(int i=0;i<arr.length;i++)
         {
             if(sum+arr[i]<=mid)
             {
                 sum+=arr[i];
             }
             else
             {
                 cnt++;
                 sum=arr[i];
             }
         }
         return cnt;
     }
     static long min(int[] arr,int n,int k)
     {
         long low=0;
         long high=0;
         for(int i=0;i<n;i++)
         {
             low=Math.max(low,arr[i]);
             high+=arr[i];
         }
         long ans=-1;
         while(low<=high)
         {
             long mid=(low+high)/2;
             int noOfPaintes=allocate(mid,arr);
             if(noOfPaintes>k)
             {
                 low=mid+1;
             }
             else
             {
                 ans=mid;
                 high=mid-1;
             }
         }
         return ans;
     }
     
    static long minTime(int[] arr,int n,int k){
        //code here
        return min(arr,n,k);
    }
}



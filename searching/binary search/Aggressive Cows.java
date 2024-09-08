/*
You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of 
aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways.

*/


class Solution {
    public static boolean isPossible(int mid,int[] arr,int k)
    {
        int prev=arr[0];
        int cnt=1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-prev>=mid)
            {
                cnt++;
                prev=arr[i];
            }
        }
        if(cnt>=k) return true;
        
        return false;
    }
    public static int binarysearch(int n,int k,int[] arr)
    {
        Arrays.sort(arr);
        int  low=1;
        int ans=0;
        int high=arr[n-1] - arr[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(isPossible(mid,arr,k))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
        
        
    }
    public static int solve(int n, int k, int[] stalls) {
        return binarysearch(n,k,stalls);
    }
}

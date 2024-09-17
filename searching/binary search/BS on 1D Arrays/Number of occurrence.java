/*
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:
Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: x = 2 occurs 4 times in the given array so the output is 4.
*/ 

class Solution {
    //finds index of first occurence of target
    int lowerbound(int[] arr,int target)
    {
        int low=0,high=arr.length-1;
        int index=-1;
        while(low<=high)
        {
           int mid=(low+high)>>1;
           if(arr[mid]==target)
           {
               index=mid;
               high=mid-1;
           }
           else if(arr[mid]<target)
           {
               low=mid+1;
           }
           else
           {
               high=mid-1;
           }
        }
        return index;
    }
    // finds the index of element just greater than target
    int upperbound(int[] arr,int target)
    {
        int low=0,high=arr.length-1;
        int index=arr.length;
        while(low<=high)
        {
            int mid=(low+high)>>1;
            
            if(arr[mid]>target)
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            
        }
        return index;
    }
    
    int count(int[] arr, int n, int x) {
        // code here
        
        int l=lowerbound(arr,x);
        if(l==-1) return 0;
        int u=upperbound(arr,x);
        // System.out.println(l+ " "+u);
        return u-l;
        
    }
}

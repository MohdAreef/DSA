/*
You are given a 2D array consisting of only 1's and 0's, where each row is sorted in non-decreasing order. You need to find and return the index 
of the first row that has the most number of 1s. If no such row exists, return -1.
Note: 0-based indexing is followed.

Examples:

Input: arr[][] = [[0, 1, 1, 1],
               [0, 0, 1, 1],
               [1, 1, 1, 1],
               [0, 0, 0, 0]]
Output: 2
Explanation: Row 2 contains 4 1's.
*/

class Solution {
    public int findonepos(int[] arr)
    {
        //binary search
        int ans=arr.length;
        int low=0,high=ans-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(arr[mid]==1)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public int findrow(int[][] mat)
    {
        int maxi=0;
        int cols=mat[0].length;
        int row=-1;
        
        for(int i=0;i<mat.length;i++)
        {
            int index=findonepos(mat[i]);
            
            if(cols-index > maxi)
            {
                row=i;
                maxi=cols-index;
            }
        }
        
        return row;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        
        return findrow(arr);
    }
}

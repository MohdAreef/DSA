/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/
class Solution {
    public int searchIn2D(int[][] mat,int target)
    {
        int low=0;
        int high=mat.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(mat[mid][0]==target)return mid;

            else if(mat[mid][0] < target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return high;
    }
    public boolean searchIn1D(int[] arr,int target)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int row=searchIn2D(matrix,target);
        if(row<0) return false;
        return searchIn1D(matrix[row],target);
        
    }
}

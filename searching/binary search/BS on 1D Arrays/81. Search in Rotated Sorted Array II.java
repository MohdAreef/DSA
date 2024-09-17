/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], 
nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and 
become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.
Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
*/

class Solution {
    public int getPivot(int[] nums, int target) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public boolean binarySearch(int low, int high, int[] arr, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return true;

            else if (target < arr[mid]) {
                // shuttle change to the previous problem
                // to avoid duplicates
                while (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }

                high = mid - 1;
            } else {
                // to avoid duplicates
                while (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
                    mid++;
                }

                low = mid + 1;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivot = getPivot(nums, target);
        boolean res = false;
        if (pivot == -1) {
            res = binarySearch(0, n - 1, nums, target);
        } else {
            if (target >= nums[0] && target <= nums[pivot]) {
                res = binarySearch(0, pivot, nums, target);
            } else {
                res = binarySearch(pivot + 1, n - 1, nums, target);
            }
        }

        return res;

    }
}

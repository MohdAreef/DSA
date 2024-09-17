/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is 
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and 
become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
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

    public int binarySearch(int low, int high, int[] arr, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;

            else if (target < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int n = nums.length;
        int pivot = getPivot(nums, target);
        if (pivot == -1) {
            return binarySearch(0, n - 1, nums, target);
        } else {
            if (target >= nums[0] && target <= nums[pivot]) {
                return binarySearch(0, pivot, nums, target);
            } else {
                return binarySearch(pivot + 1, n - 1, nums, target);
            }
        }
    }
}

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    int lowerbound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] == target) {
                index = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    // finds the index of element just greater than target
    int upperbound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int index = arr.length;
        while (low <= high) {
            int mid = (low + high) >> 1;

            if (arr[mid] > target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int l = lowerbound(nums, target);
        if (l == -1)
            return new int[] { -1, -1 };
        int r = upperbound(nums, target);
        return new int[] { l, r - 1 };
    }
}

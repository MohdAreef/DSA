/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/

class Solution {
    public int longest(int[] nums, int k) {
        int l = 0, r = 0, tempk = k;
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        while (r < n) {
            if (nums[r] == 1)
                r++;

            else if (nums[r] == 0) {
                if (tempk > 0) {
                    tempk--;
                    r++;
                } else {
                    if (nums[l] == 1) {
                        l++;
                    } else {
                        if (tempk < k) {
                            tempk++;
                        }
                        l++;
                        if (l > r)
                            r = l;
                    }
                }
            }
            maxi = Math.max(maxi, r - l + 1);
        }
        return maxi - 1;
    }

    public int longestOnes(int[] nums, int k) {
        return longest(nums, k);
    }
}

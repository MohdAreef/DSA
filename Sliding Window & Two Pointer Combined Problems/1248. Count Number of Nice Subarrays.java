/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
*/
class Solution {
    public int count(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int odds = 0;
        int cnt = 0;
        while (r < n) {

            if (nums[r] % 2 != 0)
                odds++;

            while (l <= r && odds > k) {
                if (nums[l] % 2 != 0)
                    odds--;

                l++;
            }

            if (odds <= k) {
                cnt += (r - l + 1);
            }
            r++;
        }

        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int a = count(nums, k);
        int b = count(nums, k - 1);
        return a - b;
    }
}

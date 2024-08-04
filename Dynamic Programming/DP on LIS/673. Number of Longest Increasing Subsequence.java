/*
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
*/
class Solution {
    public int findlength(int[] nums) {
        int i, j;
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j] && (dp[j] + 1) > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }

                else if (nums[i] > nums[j] && (dp[j] + 1) == dp[i]) {
                    count[i] += count[j];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(count));

        int maxi = 0, res = 0;
        for (i = 0; i < n; i++) {
            if (dp[i] > maxi) {
                maxi = dp[i];

            }
        }
        for (i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                res += count[i];
            }
        }
        return res;
    }

    public int findNumberOfLIS(int[] nums) {
        return findlength(nums);
    }
}

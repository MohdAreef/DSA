/*
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
*/

class Solution {
    public List<Integer> largest(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int i, j;
        for (i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        int maxi = dp[0];
        int index = 0;
        for (i = 1; i < n; i++) {
            if (dp[i] > maxi) {
                index = i;
                maxi = dp[i];
            }
        }

        while (parent[index] != index) {
            res.add(nums[index]);
            index = parent[index];
        }
        res.add(nums[index]);
        return res;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        return largest(nums);
    }
}

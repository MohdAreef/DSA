/* You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.
Example:
Input: 'arr' = [1, 1, 4, 5]
Output: 3
  */
public class Solution {
    public static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        

        if (ind == 0)
        {
            if(arr[ind]==0 && target==0) return 2;
            if(target==0 || target==arr[0])    return 1;
            return 0;
            
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        // Calculate the number of ways when the current element is not taken
        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        // Calculate the number of ways when the current element is taken
        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        // Store and return the result for the current state
        return dp[ind][target] = (notTaken + taken) % (int)(1e9+7);
    }
    public static int findWays(int num[], int k) {
        // Write your code here.
        int n=num.length;
        int dp[][] = new int[n][k + 1];
    // Arrays.sort(num, (a, b) -> b - a);
        for (int row[] : dp)
            Arrays.fill(row, -1);

       int res=findWaysUtil(n - 1, k, num, dp);
       res=res % (int)(1e9+7);
       return res; 
       
    
    }
}

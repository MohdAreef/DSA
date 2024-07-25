/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either 
index i or index i + 1 on the next row.
  
Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
*/

class Solution {

    public int min(int index, int row, int noofrows, List<List<Integer>> triangle, List<List<Integer>> dp) {
        if (row == noofrows) {
            return triangle.get(row).get(index);
        }
        if (dp.get(row).get(index) != -1) {
            return dp.get(row).get(index);
        }
        int left = triangle.get(row).get(index) + min(index, row + 1, noofrows, triangle, dp);
        int right = triangle.get(row).get(index) + min(index + 1, row + 1, noofrows, triangle, dp);

        dp.get(row).set(index, Math.min(left, right));
        return Math.min(left, right);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int i, j;
        int rows = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();

        for (i = 0; i < rows; i++) {
            dp.add(new ArrayList<Integer>());
        }
        for (i = 0; i < triangle.size(); i++) {
            for (j = 0; j < triangle.get(i).size(); j++) {
                dp.get(i).add(-1);
            }
        }
        return min(0, 0, rows - 1, triangle, dp);
    }
}

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals 
that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
*/

class Solution {
    public int[][] mergeintervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && intervals[i][1] >= intervals[i + 1][0] && intervals[i][1] <= intervals[i + 1][1]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;

            }

            else if (i + 1 < n && intervals[i + 1][0] >= intervals[i][0] && intervals[i + 1][0] <= intervals[i][1]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
            }
        }
        if (n >= 2 && intervals[n - 2][0] >= intervals[n - 1][0] && intervals[n - 2][1] <= intervals[n - 1][1]) {
            intervals[n - 1][0] = Math.min(intervals[n - 1][0], intervals[n - 2][0]);
            intervals[n - 1][1] = Math.max(intervals[n - 1][1], intervals[n - 2][1]);
            intervals[n - 2][0] = -1;
            intervals[n - 2][1] = -1;
        }
        for (int[] t : intervals) {
            System.out.println(Arrays.toString(t));

        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {

            if (intervals[i][0] != -1) {
                cnt++;
            }
        }
        int[][] res = new int[cnt][2];
        int k = 0;
        for (int[] t : intervals) {
            if (t[0] != -1) {
                res[k][0] = t[0];
                res[k][1] = t[1];
                k++;
            }

        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        return mergeintervals(intervals);
    }
}

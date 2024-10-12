/*
You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group 
intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.

Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
*/


class Solution {
    public int merge(int[][] arr)
    {
       int n=arr.length;
       int[] arrival=new int[n];
       int[] departure=new int[n];

       for(int i=0;i<n;i++)
       {
        arrival[i]=arr[i][0];
        departure[i]=arr[i][1];
       }
       Arrays.sort(arrival);
       Arrays.sort(departure);

       int l=0,r=0;
       int maxi=0;
       int cnt=0;
       while(l<n && r<n)
       {
        if(arrival[l]<=departure[r])
        {
            cnt++;
            l++;
        }
        else
        {
            r++;
            cnt--;
        }
        maxi=Math.max(maxi,cnt);

       }
       return maxi;
    }
    public int minGroups(int[][] intervals) {
        return merge(intervals);
    }
}

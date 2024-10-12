/*
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum 
number of days required to schedule all meetings without any conflicts.

Example 1:
Input: intervals = [(0,40),(5,10),(15,20)]
Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

*/

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
    int n=intervals.size();
    int maxi=0;
    int[] start=new int[n];
    int[] end=new int[n];
    for(int i=0;i<n;i++)
    {
        start[i]=intervals.get(i).start;
        end[i]=intervals.get(i).end;
    }

    Arrays.sort(start);
    Arrays.sort(end);
    
    int l=0,r=0;
    int cnt=0;
    while(l<n && r<n)
    {
        if(start[l]<end[r])
        {
           cnt++;
           l++;
        }
        else
        {
          cnt--;
          r++;
        }
        maxi=Math.max(maxi,cnt);
    }
    return maxi;
    }
}

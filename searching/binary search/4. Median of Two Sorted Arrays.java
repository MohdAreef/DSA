/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)). 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
*/

// O(n) solution

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l=0,r=0;
        int n=nums1.length,m=nums2.length;
        int mid1=-1,mid2=-1,sum=0;
        if((n+m)%2==0)
        {
         mid1=(n+m)/2;
         mid2=(m+n)/2+1;
        }
        else
        {
           mid1=(n+m+1)/2;
        }
        int count=1;

        while(l<n && r<m)
        {
            if(nums1[l] < nums2[r])
            {
              if(count==mid1 || count==mid2)
              {
                sum+=nums1[l];
              }
              l++;
              count++;
            }
            else
            {
            if(count==mid1 || count==mid2)
              {
                sum+=nums2[r];
              }
              r++;
              count++;
            }
        }

        while(l<n)
        {
            if(count==mid1 || count==mid2)
            {
                sum+=nums1[l];
            }
            l++;
            count++;
        }
        while(r<m)
        {
            if(count==mid1 || count==mid2)
            {
                sum+=nums2[r];
            }
            r++;
            count++;
        }
        if((n+m)%2==0)
        {
        double ans=(double)(sum) / 2;
        return ans;
        }
        return sum;    
    }
}

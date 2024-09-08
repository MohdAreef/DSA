/*
You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
Output: 113
Explanation: Allocation can be done in following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113, which is selected as the output.
*/

class Solution {
    // Function to find minimum number of pages.
    public static long allocate(int mid,int[] arr)
    {
        int cnt=1;
        int currpages=arr[0];
        for(int i=1;i<arr.length;i++)
        {
           if(currpages+arr[i]<=mid)
           {
               currpages+=arr[i];
           }
           else
           {
               cnt++;
               currpages=arr[i];
           }
        }
        return cnt;
    }
    public static long find(int n,int[] arr,int m)
    {
        int low=0;
        int high=0;
        long ans=-1;
        for(int i=0;i<arr.length;i++)
        {
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }
            while(low<=high)
            {
                int mid=(low+high)/2;
                
                long noStudents=allocate(mid,arr);
                
                if(noStudents>m)
                {
                  low=mid+1;
                    
                }
                else
                {
                    ans=mid;
                    high=mid-1;
                }
            }
            return ans;
        
    }
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(arr.length<m) return -1;
        
        return find(n,arr,m);
    }
}

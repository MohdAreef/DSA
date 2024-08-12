/*Given an array of integers. Find the Inversion Count in the array.  Two array elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and 
i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the
inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: n = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
*/

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    public static long merge(int l, int h, int mid, long[] arr) {

        int low = l, high = mid + 1;

        int n = h - l + 1;
        long[] temp = new long[n];
        int k = 0;
        long res = 0;
        while (low <= mid && high <= h) {
            if (arr[low] > arr[high]) {
                temp[k++] = arr[high];
                high++;
                res += (mid - low + 1);
            } else {

                temp[k++] = arr[low];
                low++;
            }
        }
        while (low <= mid) {
            temp[k++] = arr[low];
            low++;
        }
        while (high <= h) {
            temp[k++] = arr[high];
            high++;
        }

        for (int i = 0; i < n; i++) {
            arr[l++] = temp[i];
        }
        // System.out.println(res);
        return res;

    }

    public static long mergesort(int l, int h, long[] arr) {
        long res = 0;
        if (l < h) {
            int mid = (l + h) / 2;
            res=mergesort(l, mid, arr);
            res+=mergesort(mid + 1, h, arr);
            res += merge(l, h, mid, arr);

        }
        return res;
    }
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        
        return mergesort(0,arr.length-1,arr);
        
    }
}

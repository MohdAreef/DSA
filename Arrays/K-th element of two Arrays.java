/*
Given two sorted arrays arr1 and arr2 and an element k. The task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
Output: 6
Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10. The 5th element of this array is 6.
*/
class Solution {
    public long kthsmallet(int k,int[] arr1,int[] arr2)
    {
        int m=arr1.length;
        int n=arr2.length;
        int j=0;
        int i=m-1;
        while(i>=0 && j<n)
        {
            if(arr1[i]>arr2[j])
            {
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        k--;
        if(k<m)
        {
            return  arr1[k];
        }
        else
        {
            k=(k-m)%n;
            return  arr2[k];
        }
    }
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        return kthsmallet(k,arr1,arr2);
    }
}

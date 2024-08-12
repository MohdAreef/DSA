/*
Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements 
in the two arrays. Return the elements in sorted order.

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
*/
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static  ArrayList<Integer> find(int[] arr1,int[] arr2,int n,int m)
    {
        ArrayList<Integer> res=new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m)
        {
            if(i>0 && arr1[i]==arr1[i-1]){ i++; continue; }
            if(j>0 && arr2[j]==arr2[j-1]) {j++; continue; }
            if(arr1[i]==arr2[j]) {
                res.add(arr1[i]); i++; j++;
            }
            else if(arr1[i]<arr2[j])
            {
                res.add(arr1[i]);
                i++;
            }
            else 
            {
                res.add(arr2[j]);
                j++;
            }
        }
        while(i<n)
        {
            if(i>0 && arr1[i]!=arr1[i-1])
            {
                
            res.add(arr1[i]);
            }
            i++;
        }
        while(j<m)
        {
            if(j>0 && arr2[j]!=arr2[j-1])
            {
                
            res.add(arr2[j]);
            }
            j++;
        }
        return res;
    }
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        return find(arr1,arr2,n,m);
        
    }
}

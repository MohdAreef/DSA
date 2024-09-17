/*
You're given a sorted array 'a' of 'n' integers and an integer 'x'.

Find the floor and ceiling of 'x' in 'a[0..n-1]'.
Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.


Example:
Input: 
n=6, x=5, a=[3, 4, 7, 8, 8, 10]   

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively.
*/

public class Solution {
  public static int floor(int[] arr,int target)
  {
    int n=arr.length;
    int low=0,high=n-1;
    int value=-1;
    while(low<=high)
    {
      int mid=(low+high)/2;

      if(arr[mid]<=target)
      {
        value=arr[mid];
        low=mid+1;
      }
      else 
      {
        high=mid-1;
      }
    }
    return value;
  }
  public static int ceil(int[] arr,int target)
  {
    int n=arr.length;
    int low=0,high=n-1;
    int value=-1;

     while(low<=high)
    {
      int mid=(low+high)/2;

      if(arr[mid]>=target)
      {
        value=arr[mid];
        high=mid-1;
      }
      else 
      {
        low=mid+1;
      }
    }
    return value;
  }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Wriute your code here.
       int[] res=new int[2];
      res[0]=floor(a,x);
      res[1]=ceil(a,x);
      return res;
    }
    
}

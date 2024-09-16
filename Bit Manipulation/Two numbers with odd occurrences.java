/*
Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in 
decreasing order which has odd occurrences.
Example 1:
Input:
N = 8
Arr = {4, 2, 4, 5, 2, 3, 3, 1}
Output: {5, 1} 
Explanation: 5 and 1 have odd occurrences.
*/

class Solution
{
    public int[] findNumbers(int[] arr,int n)
    {
        int xorsum=0;
        for(int i:arr)
        {
            xorsum^=i;
        }
        int a=xorsum & (~(xorsum-1));
        // System.out.println(a);
        int num1=0;
        int num2=0;
        for(int i=0;i<n;i++)
        {
            if((a&arr[i])==a)
            {
                num1^=arr[i];
            }
            else
            {
                num2^=arr[i];
            }
        }
        int[] ans=new int[2];
        ans[1]=Math.min(num1,num2);
        ans[0]=Math.max(num1,num2);
        return ans;
    }
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        return findNumbers(Arr,N);
    }
}

/*
Given 2 sorted integer arrays arr1 and arr2. Find the median of two sorted arrays arr1 and arr2.

Examples:

Input: arr1 = [1, 2, 4, 6, 10], arr2 = [4, 5, 6, 9, 12]
Output: 11
Explanation: The merged array looks like [1, 2, 4, 4, 5, 6, 6, 9, 10, 12]. Sum of middle elements is 11 (5 + 6).
*/
class Solution {
    public int median(List<Integer> arr1, List<Integer> arr2)
    {
        int i=arr1.size()-1;
        int j=0;
        while(i>=0  && j<arr2.size()&& arr1.get(i)>arr2.get(j))
        {
            int temp=arr1.get(i);
            arr1.set(i,arr2.get(j));
            arr2.set(j,temp);
            
            i--;
            j++;
        }
        
        Collections.sort(arr1);
        Collections.sort(arr2);
        int ans=0; 
        int size=(arr1.size() + arr2.size());
        int middle=size/2;
        middle--;
        // System.out.println(middle);
        if(size%2==0)
        {
            if((middle)<arr1.size())
            {
                ans+=arr1.get(middle);
                if((middle+1) < arr1.size())
                {
                    ans+=arr1.get(middle+1);
                }
                else
                {
                    middle=middle-(arr1.size()-1);
                    ans+=arr2.get(middle);
                }
            }
            else
            {
                middle=middle-arr1.size()-1;
                ans+=arr2.get(middle);
                ans+=arr2.get(middle+1);
            }
        }
        else
        {
           if(middle<arr1.size()-1)
           {
               ans+=arr1.get(middle);
           }
           else
           {
               middle=middle-arr1.size()-1;
               ans+=arr2.get(middle);
           }
        }
        // System.out.println(arr1.toString());
        // System.out.println(arr2.toString());
        return ans;
    }
    public int sumOfMiddleElements(int[] a, int[] b) {
       int i;
       List<Integer> arr1=new ArrayList<>();
       List<Integer> arr2=new ArrayList<>();
        for(i=0;i<a.length;i++)
        {
            arr1.add(a[i]);
        }
        for(i=0;i<b.length;i++)
        {
            arr2.add(b[i]);
        }
        // code here
        return median(arr1,arr2); // This case will never occur for valid input
    }
}

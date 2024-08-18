/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/
class Solution {
    public int[]  getnse(int[] arr)
    {
        Stack<Integer> stack=new Stack<>();
          int[] nse=new int[arr.length];
          int r=arr.length-1;
          int n=arr.length;
          while(r>=0)
          {
            while(!stack.isEmpty() && arr[stack.peek()] >=arr[r])
            {
                 stack.pop();
            }
            if(stack.isEmpty())
            {
                nse[r]=n;
            }
            else 
            {
                nse[r]=stack.peek();
            }
            stack.push(r);
            r--;
          }
          return nse;
    }

      public int[]  getpse(int[] arr)
    {
         Stack<Integer> stack=new Stack<>();
          int[] pse=new int[arr.length];
          int r=0;
          int n=arr.length;
          while(r<n)
          {
            while(!stack.isEmpty() && arr[stack.peek()] >=arr[r])
            {
                 stack.pop();
            }
            if(stack.isEmpty())
            {
                pse[r]=-1;
            }
             else 
            {
                pse[r]=stack.peek();
            }

            stack.push(r);
            r++;
          }
          return pse;
    }

    public int largest(int[] arr)
    {
        int[] nse=getnse(arr);
        int[] pse=getpse(arr);
        System.out.println("nse"+Arrays.toString(nse));
        System.out.println("pse"+Arrays.toString(pse));
        int maxi=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,arr[i]*(nse[i]-pse[i]-1));
        }

        return maxi;
    }
    public int largestRectangleArea(int[] arr) {

        return largest(arr);
        
    }
}

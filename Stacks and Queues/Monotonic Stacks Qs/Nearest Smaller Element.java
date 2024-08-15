/*
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]

More formally,

    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.
*/

public class Solution {
    public int[] prevsmaller(int[] arr)
    {
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && stack.peek() >= arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                res[i]=-1;
            }
            else
            {
                res[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
        
    }
    public int[] prevSmaller(int[] A) {
        
        return prevsmaller(A);
    }
}

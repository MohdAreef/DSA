/*
You are given an array arr of N integers representing a min Heap. The task is to convert it to max Heap.

A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node. 

Input:
N = 4
arr = [1, 2, 3, 4]
Output:
[4, 2, 3, 1]
Explanation:

The given min Heap:

          1
        /   \
      2       3
     /
   4

Max Heap after conversion:

         4
       /   \
      2     3
    /
   1
*/


class Solution {
    static void heapify(int i,int n,int[] arr)
    {
        int largest=i;
        int left=2*i +1;
        int right=2*i+2;
        if(left<n && arr[left]>arr[largest])
        {
            largest=left;
        }
        if(right<n && arr[right]>arr[largest])
        {
            largest=right;
        }
        if(largest!=i)
        {
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            
            heapify(largest,n,arr);
        }
    }
    static void convert(int n,int[] arr)
    {
        
       
        for(int i=n/2 -1;i>=0;i--)
        {
           
            heapify(i,n,arr);
        }
        
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
     convert(N,arr);

  }
}
     

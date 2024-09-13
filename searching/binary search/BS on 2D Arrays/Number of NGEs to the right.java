/*
Given an array of N integers and Q queries of indices. Return a list NGEs[] where NGEs[i] stores the count of elements strictly greater than the 
current element (arr[indices[i]]) to the right of indices[i].

Examples :

Input:  arr[]     = [3, 4, 2, 7, 5, 8, 10, 6]
        queries = 2
        indices[] = [0, 5]
Output:  6, 1
Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6. The next greater elements to the right of 8(index 5) is only 10.
*/

class Pair
{
    int index,value;
    Pair(int index,int value)
    {
        this.index=index;
        this.value=value;
    }
}
class Solution {
  public static int[] count(int n,int[] arr,int que,int[] indices)
  {
     Stack<Pair> st=new Stack<>();
     int[] nge=new int[n];
     
     for(int i=n-1;i>=0;i--)
     {
         while(!st.isEmpty() && st.peek().value<arr[i])
         {
             st.pop();
         }
         
         if(st.isEmpty())
         {
             nge[i]=-1;
         }
         else
         {
             nge[i]=st.peek().index;
         }
         st.push(new Pair(i,arr[i]));
     }
     return nge;
  }
  
  public static int findcount(int[] arr,int m,int index)
  {
      int count=0;
      if(index==-1) return count;
      for(int i=index;i<arr.length;i++)
      {
          if(arr[i]>m) count++;
      }
      return count;
  }
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int[] res=new int[queries];
    int[] nge=count(N,arr,queries,indices);
    // System.out.println(Arrays.toString(nge));
    
    for(int i=0;i<queries;i++)
    {
        res[i]=findcount(arr,arr[indices[i]],nge[indices[i]]);
    }
    
    return res;
    
     
  }
}
     

/*
You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.

The output will be 1 if the subsequence returned by the function is present in the array arr
If the subsequence is not present in the array then return an empty array, the driver code will print 0.
If the subsequence returned by the function is not in the format as mentioned then the output will be -1.
*/


class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public int[] nge(int[] arr)
    {
        int ngearr[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek() <= arr[i])
            {
                st.pop();
            }
            
            if(st.isEmpty())
            {
                ngearr[i]=-1;
            }
            else
            {
                ngearr[i]=st.peek();
            }
            
            st.push(arr[i]);
        }
        return ngearr;
    }
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        
        int[] ngearr=nge(arr);
        Stack<Integer> st=new Stack<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && st.peek()>=arr[i])
            {
                st.pop();
            }
            
            if(!st.isEmpty())
            {
                if(ngearr[i]!=-1)
                {
                    res.add(st.peek());
                    res.add(arr[i]);
                    res.add(ngearr[i]);
                    return res;
                }
            }
            
            st.push(arr[i]);
        }
        return res;
    }
}

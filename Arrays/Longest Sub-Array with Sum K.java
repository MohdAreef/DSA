/*
Given an array arr containing n integers and an integer k. Your task is to find the length of the longest Sub-Array with the sum of the elements 
equal to the given value k.
  
Examples:
 
Input :
arr[] = {10, 5, 2, 7, 1, 9}, k = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
*/
class Solution{
    
    public static int len(int[] arr,int n,int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int maxi=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(!map.containsKey(sum))
            {
            map.put(sum,i);
            }
            
            if(map.containsKey(sum-k))
            {
                maxi=Math.max(maxi,i-map.get(sum-k));
            }
        }
        return maxi;
        
    }
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        return len(A,N,K);
    }
    
    
}

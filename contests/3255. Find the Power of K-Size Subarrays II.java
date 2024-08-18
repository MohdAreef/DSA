/*
You are given an array of integers nums of length n and a positive integer k.

The power of an array is defined as:

Its maximum element if all of its elements are consecutive and sorted in ascending order.
-1 otherwise.
You need to find the power of all 
subarrays
 of nums of size k.

Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].
 
Example 1:

Input: nums = [1,2,3,4,3,2,5], k = 3

Output: [3,4,-1,-1,-1]
*/

  public int[] getcons(int[] nums)
    {
         int n=nums.length;
        int[] cons=new int[n];
        cons[n-1]=0;
        Arrays.fill(cons,1);
        for(int i=n-2;i>=0;i--)
        {
            if((nums[i]+1)==nums[i+1])
            {
               
                      cons[i]=cons[i+1]+1;
              
            }
           
        }
        return cons;
    }
    public int[] result(int[] nums,int k)
    {
        
        
        int n=nums.length;
        if(n==1) return new int[]{nums[0]};
     
        int[] cons=getcons(nums);
        System.out.println(Arrays.toString(cons));
         
        int[] ans=new int[n-k+1];
        for(int i=0;i<ans.length;i++)
        {
            if( cons[i]>= k)
            {
                ans[i]=nums[i+k-1];
            } 
            else
            {
                ans[i]=-1;
            }
        }
        return ans;
    }
    public int[] resultsArray(int[] nums, int k) {
        
        return result(nums,k);
    }
}

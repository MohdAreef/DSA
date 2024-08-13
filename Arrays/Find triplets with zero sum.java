//Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero. Return true, if there is at least one triplet 
//following the condition else return false.

class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean find(int arr[],int n)
    {
        Arrays.sort(arr);
        for(int i=0;i<n;i++)
        {
            int l=i+1,r=n-1;
            
            while(l<r)
            {
                if(arr[i]+arr[l]+arr[r]==0)
                {
                    return true;
                }
                if(arr[i]+arr[l] + arr[r] > 0)
                {
                    r--;
                }
                else if(arr[l] + arr[r] <0)
                {
                    l++;
                }
                else
                {
                    l++;
                }
            }
        }
        return false;
    }
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        return find(arr,n);
    }
}

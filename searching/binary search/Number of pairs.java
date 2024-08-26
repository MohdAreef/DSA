/*
Given two positive integer arrays arr and brr, find the number of pairs such that xy > yx (raised to power of) where x is an element from arr and y is an element from brr.

Examples :

Input: arr[] = [2, 1, 6], brr[] = [1, 5]
Output: 3
Explanation: The pairs which follow xy > yx are: 21 > 12,  25 > 52 and 61 > 16 .
*/

class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    
    public long get(int[] y,int target)
    {
        int n=y.length;
        int low=0,high=n-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(y[mid]>target)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        // System.out.println("ans"+ans);
        if(ans==-1) return 0;
        return n - ans;
    }
    public long count(int[] x,int[] y ,int m,int n)
    {
        Arrays.sort(y);
        
        int ones=0,twos=0,threes=0,fours=0;
        long total=0;
        for(int i=0;i<n;i++)
        {
            if(y[i]==1) ones++;
            else if(y[i]==2) twos++;
            else if(y[i]==3) threes++;
            else if(y[i]==4) fours++;
        }
       
        for(int i=0;i<m;i++)
        {
            if(x[i]==1)
            {
                continue;
            }
            
            total+=ones;
            
            if(x[i]==2)
            {
                total-=threes;
                total-=fours;
                
            }
            
            else if(x[i]==3)
            {
                total+=twos;
            }
            
            long res=get(y,x[i]);
            
            total+=res;
        }
        return total;
    }
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        return count(x,y,M,N);
    }
}

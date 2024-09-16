/*
Given a number N. Find its unique prime factors in increasing order.
Example 1:

Input: N = 100
Output: 2 5
Explanation: 2 and 5 are the unique prime
factors of 100.
*/

class Solution
{
    public int[] primefactors(int n)
    {
        List<Integer> list=new ArrayList<>();
       for(int i=2;i<=n;i++)
       {
           boolean flag=false;
           while(n%i==0)
           {
               if(flag==false)
               {
                   flag=true;
                   list.add(i);
               }
               n=n/i;
           }
       }
       int[] ans=new int[list.size()];
       int i=0;
       for(int k:list)
       {
           ans[i++]=k;
       }
       return ans;
    }
    public int[] AllPrimeFactors(int N)
    {
        // code here
        return primefactors(N);
    }
}

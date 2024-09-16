/*
Given an integer N, print all the divisors of N in the ascending order.
Example 1:

Input : 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely 
divisible by 1, 2, 4, 5, 10 and 20.
*/

class Solution {
    public static void print(int n)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        if(n==1) System.out.print(n+" ");
        else
        {
        for(int i=1;i*i<=n;i++)
        {
            if(n%i==0)
            {
                pq.add(i);
                if(i!=(n/i))
                pq.add(n/i);
            }
        }
        while(!pq.isEmpty())
        {
            System.out.print(pq.poll()+" ");
        }
        }
    }
    public static void print_divisors(int n) {
        // code here
        print(n);
    }
}

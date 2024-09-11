/*
Due to the rise of covid-19 cases in India, this year BCCI decided to organize knock-out matches in IPL rather than a league.

Today is matchday 2 and it is between the most loved team Chennai Super Kings and the most underrated team - Punjab Kings. Stephen Fleming, the 
head coach of CSK, analyzing the batting stats of Punjab. He has stats of runs scored by all N players in the previous season and he wants to find the
maximum score for each and every contiguous sub-list of size K to strategize for the game.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6

*/

class Solution {
   static class Pair
    {
        int index,value;
        Pair(int index,int value)
        {
            this.index=index;
            this.value=value;
        }
    }
    static ArrayList<Integer> max(int[] arr,int n, int k)
    {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        ArrayList<Integer> result=new ArrayList<>();
        
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        result.add(pq.peek());
        for(int i=k;i<n;i++)
        {
                
                pq.remove(arr[i-k]);
                pq.add(arr[i]);
            
            result.add(pq.peek());
        }
        
        return result;
    }
    static ArrayList<Integer> slidemax(int[] arr,int n,int k)
    {
        int maxi=Integer.MIN_VALUE;
        ArrayList<Integer> result=new ArrayList<>();
       Deque<Pair> dq = new ArrayDeque<>();
        
        
        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && dq.peekLast().value<arr[i])
            {
                dq.pollLast();
            }
            dq.addLast(new Pair(i,arr[i]));
        }
        
        result.add(dq.peekFirst().value);
         
        for(int i=k;i<n;i++)
        {
            int last=i-k;
            
            if(dq.peekFirst().index==last)
            {
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && dq.peekLast().value <arr[i])
            {
                dq.pollLast();
            }
            dq.add(new Pair(i,arr[i]));
            result.add(dq.peekFirst().value);
        }
        
        return result;
    }
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        // return max(arr,n,k);
        return slidemax(arr,n,k);
    }
}

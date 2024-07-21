/*
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 
is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.
*/

// User function Template for Java

class Pair
{
    int node,step;
    Pair(int step,int node)
    {
        this.step=step;
        this.node=node;
    }
}
class Solution {
    int multiply(int[] arr,int start,int end)
    {
        int i;
        int[] dist=new int[100000];
        for(i=0;i<100000;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        // HashSet<Pair> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        
        q.add(new Pair(0,start));
        dist[start]=0;
        
        
        
        while(!q.isEmpty())
        {
        Pair temp=q.poll();
        int node=temp.node;
        int step=temp.step;
        
        if(node==end)
        {
            return step;
        }
        
        for(i=0;i<arr.length;i++)
        {
            int num= (node*arr[i]) % 100000;
            if(step+1<dist[num] )
            {
            dist[num]=step+1;
            q.add(new Pair(step+1,num));
                
            }
        }
        }
        
        return -1;
        
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        return multiply(arr,start,end);
    }
}

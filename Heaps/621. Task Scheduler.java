/*
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, 
but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

​Return the minimum number of intervals required to complete all tasks.

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
*/

class Pair
{
    int time;
    int freq;

    Pair(int time,int freq)
    {
        this.time=time;
        this.freq=freq;
    }
}
class Solution {
    public int leastnoofintervals(char[] tasks,int n)
    {
        
        Queue<Pair> queue=new LinkedList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> b.freq-a.freq);
        int len=tasks.length;
        int[] count=new int[26];
        Arrays.fill(count,0);
        for(char c:tasks)
        {
               count[c-'A']++;
        }

        for(int i=0;i<26;i++)
        {
            if(count[i]>0)
            {
             pq.add(new Pair(0,count[i]));
            }
        }


        int timer=0;
       

        while(!pq.isEmpty() || !queue.isEmpty())
        {
            
            if(!queue.isEmpty())
            {
                if((timer - queue.peek().time) > n)
                {
                    pq.add(queue.remove());
                }
            }

           if(!pq.isEmpty())
           {

            Pair curr=pq.remove();
            curr.time=timer;
            curr.freq=curr.freq-1;
            if(curr.freq>0)
            {
                queue.add(curr);
            }
           }
            timer++;
        }
        return timer;

    }
    public int leastInterval(char[] tasks, int n) {
        return leastnoofintervals(tasks,n);
    }
}

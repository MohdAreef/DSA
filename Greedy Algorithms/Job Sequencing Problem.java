/*
Given a set of n jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job 
is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs 
to be completed to earn the profit.
Examples :

Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
Output: 2 60
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
*/

class Solution
{
    
    //Function to find the maximum profit and the number of jobs done.
    int[] time(Job[] arr,int n)
    {
        Arrays.sort(arr,(x,y)->y.profit-x.profit);
        int maxi=0;
        int i;
        for( i=0;i<n;i++)
        {
            maxi=Math.max(maxi,arr[i].deadline);
        }
        int[] gantt=new int[maxi];
        Arrays.fill(gantt,-1);
        for(i=0;i<n;i++ )
        {
            
                int index=arr[i].deadline -1;
                while(index>=0)
                {
                    if(gantt[index]==-1)
                    {
                        gantt[index]=arr[i].profit;
                        break;
                    }
                    index--;
                }
            
            
        }
        int sum=0;
        int cnt=0;
        for( i=0;i<maxi;i++)
        {
            if(gantt[i]!=-1)
            {
                cnt++;
            sum+=gantt[i];
            }
        }
        int[] res=new int[]{cnt,sum};
        return res;
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        return time(arr,n);
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

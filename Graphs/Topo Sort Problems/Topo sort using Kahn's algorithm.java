//{ Driver Code Starts

class Solution
{
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
      int i;
        // add your code here
      int indegree[]=new int[V];
      Queue<Integer> queue=new LinkedList<Integer>();
      for(i=0;i<V;i++)
      {
          indegree[i]=0;
      }
      for(i=0;i<V;i++)
      {
      for(Integer it:adj.get(i))
      {
          indegree[it]++;
      }
      }
      
    //   System.out.println(Arrays.toString(indegree));
      int[] ans=new int[V];
      int j=0;
      for(i=0;i<V;i++)
      {
          if(indegree[i]==0)
          {
              queue.add(i);
              ans[j++]=i;
          }
      }
       
      while(!queue.isEmpty())
      {
         int node=queue.poll();
         
         for(Integer it:adj.get(node))
         {
             indegree[it]--;
             if(indegree[it]==0)
             {
                 queue.add(it);
                 ans[j++]=it;
             }
         }
      }
    
      return ans;
      
        
    }
}

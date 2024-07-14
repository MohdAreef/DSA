

class Solution {
    // Function to detect cycle in a directed graph.
    
    
    public boolean detectCycle(int V,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] pathvis,int node)
    {
        visited[node]=true;
        pathvis[node]=true;
        for(Integer it: adj.get(node))
        {
            if(visited[it]==true && pathvis[it]==true)
            {
                return true;
            }
            else 
            {
                if(visited[it]==false && detectCycle(V,adj,visited,pathvis,it))
                {
                    return true;
                }
            }
        }
        pathvis[node]=false;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        
        boolean[] visited=new boolean[V];
        boolean[] pathvis=new boolean[V];
        int i;
        for(i=0;i<V;i++)
        {
            visited[i]=false;
            pathvis[i]=false;
        }
        for(i=0;i<V;i++)
        {
            if(visited[i]==false && detectCycle(V,adj,visited,pathvis,i))
            {
                return true;
            }
        }
        return false;
        
    }
}

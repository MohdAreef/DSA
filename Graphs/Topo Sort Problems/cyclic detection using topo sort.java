// cyclic detection in directed graph using TOPOLOGICAL SORT alogorithm.
// Topo sort not possible for directed graph with cycles 
// if TOPO sort not possible for a directed graph then we can say that graph has a cycle

class Solution {
    
    public boolean toposort(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int i;
        int[] indegree=new int[V];
        for(i=0;i<V;i++)
        {
            for(Integer it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
                list.add(i);
            }
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(Integer it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    list.add(it);
                    queue.add(it);
                }
            }
        }
        return (list.size()==V) ? false : true;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        return toposort(V,adj);
    }
}

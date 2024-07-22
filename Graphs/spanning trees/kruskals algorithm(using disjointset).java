// kruskal's algorithm using Disjointset data structure 


class Disjointset
{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    
    Disjointset(int n)
    {
        for(int i=0;i<=n;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    
    public int  findUparent(int node)
    {
        if(parent.get(node)==node)
        {
            return node;
        }
        int uparent=findUparent(parent.get(node)); 
        parent.set(node,uparent);
        return uparent;
    }
    
    public int unionBySize(int u,int v)
    {
        int uparent_u=findUparent(u);
        int uparent_v=findUparent(v);
      
        if(uparent_u==uparent_v)
        {
            return -1;
        }
        
        else if(size.get(uparent_u)<size.get(uparent_v))
        {
            parent.set(uparent_u,uparent_v);
            size.set(uparent_v,size.get(uparent_u)+size.get(uparent_v));
        }
          
        else
        {
            parent.set(uparent_v,uparent_u);
            size.set(uparent_u,size.get(uparent_u)+size.get(uparent_v));
        }
      
        return 1;
    }
}


class Pair
{
    int u,v,weight;
    Pair(int u,int v,int weight)
    {
        this.u=u;
        this.v=v;
        this.weight=weight;
    }
}

 class Solution {
     static int kruskals(int V,int E,List<List<int[]>> adj)
     {
         int i,j;
          PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.weight-y.weight);
          for(i=0;i<adj.size();i++)
          {
              for(j=0;j<adj.get(i).size();j++)
              {
                  int v=adj.get(i).get(j)[0];
                  int wt=adj.get(i).get(j)[1];
                  pq.add(new Pair(i,v,wt));
                  pq.add(new Pair(v,i,wt));
                                  
              }
          }
          
          Disjointset ds=new Disjointset(V);
          int sum=0;
          while(!pq.isEmpty())
          {
              Pair temp=pq.poll();
             if(ds.unionBySize(temp.u,temp.v)==1)
             {
                 sum+=temp.weight;
             }
          }
          return sum;  
     }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        return kruskals(V,E,adj);
    }
}

// Problem Statement
/*  Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.*/

class Pair
{
    int i,j,cost;
    Pair(int i,int j,int cost)
    {
        this.i=i;
        this.j=j;
        this.cost=cost;
    }
}

class Solution {
    public int findpath(int[][] grid)
    {
        int i,j;
        int n=grid.length;
      
        int[][] dist=new int[n][n];
        
        int[] rows=   { 0, 1,1,1,0,-1,-1,-1};
        int[] columns={-1,-1,0,1,1,1,0,-1};

        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        } 
        if(grid[0][0]==1)
        {
            return -1;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.cost -y.cost);
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            int r=temp.i;
            int c=temp.j;
            int cost=temp.cost;
            for(i=0;i<8;i++)
            {
                    int nextrow=r+rows[i];
                    int nextcol=c+columns[i];
                    if(nextrow>=0 && nextrow<n && nextcol>=0 && nextcol<n && grid[nextrow][nextcol]==0)
                    {
                        if(cost + 1 < dist[nextrow][nextcol])
                        {
                            dist[nextrow][nextcol]=cost + 1;
                            pq.add(new Pair(nextrow,nextcol,dist[nextrow][nextcol]));
                        }
                    }
            }
        }

        if(dist[n-1][n-1]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dist[n-1][n-1] +1;
    
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        return findpath(grid);
    }
}

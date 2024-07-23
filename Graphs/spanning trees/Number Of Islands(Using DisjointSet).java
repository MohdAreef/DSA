/*
You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. Matrix elements
is 0  if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. 
The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from 
sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.
Note : An island means group of 1s such that they share a common side.
*/




// DisjointSet Data Structure
class Disjointset {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    Disjointset(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUparent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int uparent = findUparent(parent.get(node));
        parent.set(node, uparent);
        return uparent;
    }

    public int unionBySize(int u, int v) {
        int uparent_u = findUparent(u);
        int uparent_v = findUparent(v);

        if (uparent_u == uparent_v) {
            return -1 ;
        }

        else if (size.get(uparent_u) < size.get(uparent_v)) {
            parent.set(uparent_u, uparent_v);
            size.set(uparent_v, size.get(uparent_u) + size.get(uparent_v));
        }

        else {
            parent.set(uparent_v, uparent_u);
            size.set(uparent_u, size.get(uparent_u) + size.get(uparent_v));
        }
        return 1;

        
    }
}


class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int i,j;
        int[] nextrows =  {0,1,0,-1};
        int[] nextcolumns={-1,0,1,0};
        
        List<Integer> result=new ArrayList<>();
        
        int [][] grid=new int[rows][cols];
        for(i=0;i<rows;i++)
        {
            for(j=0;j<cols;j++)
            {
                grid[i][j]=0;
            }
        }
        int count=0;
        Disjointset ds=new Disjointset(rows*cols);
        boolean [][] vis=new boolean[rows][cols];
        for(i=0;i<rows;i++)
        {
            for(j=0;j<cols;j++)
            {
                vis[i][j]=false;
            }
        }
        for(i=0;i<operators.length;i++)
        {
            int r=operators[i][0];
            int c=operators[i][1];
            
            if(vis[r][c]==true)
            {
                result.add(count);
                continue;
                
            }
            vis[r][c]=true;
            grid[r][c]=1;
            
            count++;
            
            for(j=0;j<4;j++)
            {
                int newrow=r+nextrows[j];
                int newcol=c+nextcolumns[j];
                
                if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && grid[newrow][newcol]==1)
                {
                    int current=r * cols + c;
                    int next= newrow * cols + newcol;
                    if(ds.unionBySize(current,next)==1)
                    {
                        count--;
                    }
                }
            }
            
            
            result.add(count);
        }
        return result;
        
        
    }
    
}

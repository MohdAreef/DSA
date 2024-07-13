class Solution {
  
    void dfs(int r,int c,int[][] grid,boolean[][] vis,ArrayList<String> temp,int r0,int c0)
    {
        int m=grid.length;
        int n=grid[0].length;
        
        vis[r][c]=true;
         // temp.add(toString(r-r0,c-c0));
        temp.add(String.valueOf(r - r0) + "," + String.valueOf(c - c0));
        int rows[]={0,1,0,-1};
        int cols[]={-1,0,1,0};
        for(int i=0;i<4;i++)
        {
            int newrow=r+rows[i];
            int newcol=c+cols[i];
            if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && !vis[newrow][newcol] && grid[newrow][newcol]==1)
            {
               
                dfs(newrow,newcol,grid,vis,temp,r0,c0);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m=grid.length;
        int n=grid[0].length;
        
        boolean[][] vis=new boolean[m][n];
        HashSet<ArrayList<String>> set=new HashSet<ArrayList<String>>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !vis[i][j])
                {
                    ArrayList<String> temp=new ArrayList<>();
                    vis[i][j]=true;
                    dfs(i,j,grid,vis,temp,i,j);
                    set.add(temp);
                } 
            }
        }
        return set.size();
        
    }
}

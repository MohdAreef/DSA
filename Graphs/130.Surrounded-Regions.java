class Solution {
    void dfs(int i,int j,boolean[][] vis,char[][] board)
    {
       vis[i][j]=true;
        int row[]={0,1,0,-1};
        int col[]={-1,0,1,0};
        
        int rows=board.length;
        int cols=board[0].length;

        for(int m=0;m<4;m++)
        {
            int newrow=i+row[m];
            int newcol=j+col[m];
            if(newrow>=0 && newrow<rows && newcol>=0 && newcol <cols)
            {
                if(board[newrow][newcol]=='O' && vis[newrow][newcol]==false)
                {
                    dfs(newrow,newcol,vis,board);
                }
            }
        }
    }
    public void solve(char[][] board) 
    {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O' && vis[0][i]==false)
            {
                dfs(0,i,vis,board);
            }
            if(board[m-1][i]=='O' && vis[m-1][i]==false)
            {
                dfs(m-1,i,vis,board);
            }
        }

        for(int j=0;j<m;j++)
        {
            if(board[j][0]=='O' && vis[j][0]==false)
            {
                dfs(j,0,vis,board);
            }
            if(board[j][n-1]=='O' && vis[j][n-1]==false)
            {
              dfs(j,n-1,vis,board);
            }
        }
        for(int k=0;k<m;k++)
        {
            for(int l=0;l<n;l++)
            {
                if(board[k][l]=='O' && vis[k][l]==false)
                {
                    board[k][l]='X';
                }
            }
        }
    }
}

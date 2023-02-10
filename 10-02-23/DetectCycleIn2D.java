class Pair{
    int first,second,third,fourth;
    public Pair(int first,int second,int third,int fourth)
    {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
     
    }
}

class Solution {

    public boolean bfs(int r,int c,int[][] vis,char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] =1;
        Queue<Pair> q = new LinkedList<>();
     
        q.add(new Pair(r,c,-1,-1));
      
        char value = grid[r][c];


        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            int prow = q.peek().third;
            int pcol = q.peek().fourth;
            q.remove();
            
            //finding neighbours
            for(int i=0;i<4;i++)
            {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==value)
                {
                    
                    vis[nrow][ncol] =1;
                    q.add(new Pair(nrow,ncol,row,col));
                    
                }
                else if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && nrow!=prow && ncol!=pcol && vis[nrow][ncol]==1 && grid[nrow][ncol]==value)
                {
                    return true;
                }
                
            }
        }
        return false;
    }


    public boolean containsCycle(char[][] grid) {
        
        int n = grid.length;
        int m  = grid[0].length;
        int[][] vis = new int[n][m];
        for(int[] row : vis)
        {
            Arrays.fill(row,0);
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0)
                {
                    if(bfs(i,j,vis,grid))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

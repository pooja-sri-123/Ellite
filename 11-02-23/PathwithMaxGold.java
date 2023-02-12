class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int n =grid.length;
        int m = grid[0].length;
        int maxGold=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                maxGold = Math.max(maxGold,dfs(grid,n,m,r,c));
            }
        }
        return maxGold;

    }
    int[] dir = {0,1,0,-1,0};
    int dfs(int[][] grid,int n,int m,int r,int c){
        if(r<0 || r ==n ||c<0 || c==m || grid[r][c]==0) return 0;
        int start = grid[r][c];
        grid[r][c]=0;
        int maxGold=0;
        for(int i=0;i<4;i++){
           int nrow= dir[i] + r;
           int ncol= dir[i+1] + c;
            maxGold = Math.max(maxGold,dfs(grid,n,m,nrow,ncol));

        }
        grid[r][c] =start;
        return maxGold + start;
    }
}

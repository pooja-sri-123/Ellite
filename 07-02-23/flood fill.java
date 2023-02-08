class Solution {
    private void dfs(int row,int col,int[][] res,int[][] image ,int newColor,int delRow[],int delCol[],int inColor){
        res[row][col] = newColor;
        int n= image.length;
        int m= image[0].length;
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == inColor && res[nrow][ncol] != newColor){
                dfs(nrow,ncol,res,image,newColor,delRow,delCol,inColor);
            }
        }
        }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int inColor = image[sr][sc];
        int[][] res = image;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        dfs(sr,sc,res,image,newColor,delRow,delCol,inColor);
        return res;

    }
   
}

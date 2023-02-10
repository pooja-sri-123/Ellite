class Pair{
    int first;
    int second;
    int third;
    Pair(int first,int second,int third){
        this.first=first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> queue = new LinkedList<Pair>();
        int n=mat.length;
        int m = mat[0].length;
        int visited[][]=new int[n][m];
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] =1;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }

        int delRow[]= {-1,1,0,0};
        int delCol[]= {0,0,1,-1};
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col=queue.peek().second;
            int steps = queue.peek().third;
            queue.poll();
            dist[row][col]=steps;
            for(int i=0;i<4;i++){
                int nrow=row + delRow[i];
                int ncol=col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol<m && visited[nrow][ncol]==0){
                    visited[nrow][ncol] =1;
                    queue.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
    return dist;
    }
     
    
}

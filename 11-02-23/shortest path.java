class Pair{
    int first;
    int second;
    int distance;
    Pair(int first,int second,int distance){
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0] == 1 || grid[row-1][col-1] == 1) return -1;
        int dir[][] ={{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1} };

        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(0,0,1));
        grid[0][0]=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair temp = q.poll();
                int x = temp.first;
                int y = temp.second;
                int cost = temp.distance;

                if(x== row-1 && y==col-1) return cost;
                for(int[] neigh:dir){
                    int nrow=x+ neigh[0];
                    int ncol =y + neigh[1];
                    if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && grid[nrow][ncol] == 0){
                        q.add(new Pair(nrow,ncol,cost+1));
                        grid[nrow][ncol]=1;
                    }
                }
            }
        }
        return -1;
}
}

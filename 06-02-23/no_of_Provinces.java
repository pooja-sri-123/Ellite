class Solution {
    public int findCircleNum(int[][] isConnected) {
        int  visited[] = new int[isConnected.length];
        int count=0;
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
         for(int i=0;i<isConnected.length;i++){
            if(visited[i] == 0){
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;
    }
    public void dfs(int i ,ArrayList<ArrayList<Integer>>adj,int visited[] ){
        visited[i]= 1;
        for(int e:adj.get(i)){
            if(visited[e] == 0){
                dfs(e,adj,visited);
            }
        }
    }
}

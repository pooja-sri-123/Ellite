class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(0,vis,rooms);
        for(boolean val:vis){
            if(!val) return false;
        }
        return true;

    }
    public static void dfs(int node,boolean[] vis,List<List<Integer>>rooms){
        vis[node]=true;
        for(int neigh:rooms.get(node)){
             if(!vis[neigh]){
                dfs(neigh,vis,rooms);
            }
        }
    }
}

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V+1];
        visited[0] = true;
        ArrayList<Integer> res = new ArrayList<>();
        
        dfs(adj,res,visited,0);
        return res;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> res,boolean visited[],int node){
        visited[node] = true;
        res.add(node);
        for(int neigh: adj.get(node)){
            if(!visited [neigh]){
                dfs(adj,res,visited,neigh);

            }

        }
        
        
    }
}

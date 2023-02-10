class Solution {
    private int timer = 1;
    public void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[] vis,int[]dis,int[] low,List<List<Integer>> bridges){
        vis[node] =1;
        dis[node] = low[node] = timer;
        timer++;
        
        for(Integer it:adj.get(node)){
            if(it == parent) continue;
            if(vis[it] ==0){
                dfs(it,node,adj,vis,dis,low,bridges);
                low[node] = Math.min(low[node],low[it]);
            }
            if(low[it] > dis[node]){
                bridges.add(Arrays.asList(it,node));
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(List<Integer> it:connections){
            int u =it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis =new int[n];
        int[] dis = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,adj,vis,dis,low,bridges);
        return bridges;
    }
    }

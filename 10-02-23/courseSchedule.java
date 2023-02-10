class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
         int[] visited = new int[V];
         for(int i=0;i<V;i++){
            for(int neigh:adj.get(i)){
                visited[neigh]++;
         }
     }
        Queue<Integer> queue =new LinkedList<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                queue.add(i);
            } 
        }
        List<Integer> res = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int node=queue.peek();
            queue.poll();
            res.add(node);
            for(int neigh:adj.get(node)){
                visited[neigh]--;
                if(visited[neigh]==0){
                    queue.add(neigh);
                }
            }
         
        }
        if(res.size() == V) {
            return true;
        }
        return false;
    
    }
}

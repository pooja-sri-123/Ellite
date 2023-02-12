class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i]=1;

            while(!queue.isEmpty()){
                int curr =queue.poll();
                for(int neigh: graph[curr]){
                    if(visited[neigh] == 0) {
                        visited[neigh] = -visited[curr];
                        queue.add(neigh);
                    }
                    else if(visited[neigh]  != -visited[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[V];
        q.add(0);
        visited[0]=true;

        while(q.size()>0){

            Integer tem = q.remove();
            ans.add(tem);
            for(Integer i : adj.get(tem)){
                if(visited[i]==false){
                    q.add(i);
                    visited[i]=true;
              }
            }
        }

        return ans;
    }
}

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            visited[i]=0;
        }
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(bfs(i,V,visited,adj) == true) return true;
            }
        }
        return false;
    }
    public boolean  bfs(int source,int V,int[] visited, ArrayList<ArrayList<Integer>>  adj){
        visited[source]=1;
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(source,-1));
        while(!queue.isEmpty()){
            int node = queue.peek().first;
            int parent = queue.peek().second;
            for(int neigh:adj.get(node)){
                if(visited[neigh] == 0){
                    visited[neigh]=1;
                    queue.add(new Pair(neigh,node));
                }
                else if(neigh != parent) return true;
            }
        }
        return false;
        
        
}
}

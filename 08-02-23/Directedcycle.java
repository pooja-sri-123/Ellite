//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            for(int neigh:adj.get(i)){
                visited[neigh]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                queue.add(i);
            }
        }
        int count =0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            count++;
            for(int neigh:adj.get(node)){
                visited[neigh]--;
                if(visited[neigh]==0){
                    queue.add(neigh);
                }
            }
        }
        if(count == V) {
            return false;
        }
        return true;
}
}

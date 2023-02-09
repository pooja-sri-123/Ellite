
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
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
     int[] res =new int[V];
     int i=0;
     while(!queue.isEmpty()){
         int node=queue.peek();
         res[i++] = node;
         queue.poll();
         for(int neigh:adj.get(node)){
             visited[neigh]--;
             if(visited[neigh]==0){
                 queue.add(neigh);
             }
         }
         
         }
         return res;
    
    }
}

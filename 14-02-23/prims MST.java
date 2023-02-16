
class Result {
        
public static class Pair{
        int v,w;
        Pair(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
    // Write your code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.w-b.w);
         ArrayList<ArrayList<ArrayList<Integer>>> ls= new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<=n;i++){
             ls.add(new ArrayList<ArrayList<Integer>>());
        }
        for(List<Integer> e:edges){
            int u=e.get(0);
            int v=e.get(1);
            int w=e.get(2);
            ArrayList<Integer> t1=new ArrayList<>();
            ArrayList<Integer> t2=new ArrayList<>();
            t1.add(v);
            t1.add(w);
            t2.add(u);
            t2.add(w);
            ls.get(u).add(t1);
            ls.get(v).add(t2);
        }
        boolean vis[]=new boolean[n+1];
        pq.add(new Pair(start,0));
        int sum=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(!vis[p.v]){
                vis[p.v]=true;
                sum+=p.w;
            }
            for(ArrayList<Integer> adj:ls.get(p.v)){
                if(!vis[adj.get(0)]){
                    pq.add(new Pair(adj.get(0),adj.get(1)));
                }
            }
        }
        return sum;
    }
}

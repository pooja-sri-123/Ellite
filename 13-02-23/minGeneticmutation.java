class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q =new LinkedList<>();
        Set<String>visited= new HashSet<>();
        q.add(startGene);
        int level =0;
        visited.add(startGene);
        while(!q.isEmpty()){
            int size= q.size();
            for(int j=0;j<size;j++){
                String node =q.remove();
                if(node.equals(endGene)){
                    return level;
                }
                for(char ch:new char[]{'A','C','T','G'}){
                    for(int i=0;i<node.length();i++){
                        String neigh = node.substring(0,i) + ch + node.substring(i+1);
                        if(!visited.contains(neigh) && Arrays.asList(bank).contains(neigh)){
                            q.add(neigh);
                            visited.add(neigh);
                        }
                    }
                }
            }
            level++;             
        }
        return -1;
    }
    
}

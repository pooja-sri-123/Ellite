class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result =new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode>queue= new LinkedList<>();
        queue.add(root);
        Boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer>sublist=new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                if(flag)
                    sublist.add(curr.val);
                else
                    sublist.add(0,curr.val);    
            }
            flag =  !flag;
            result.add(sublist);

        }
        return result;
        
    }
}

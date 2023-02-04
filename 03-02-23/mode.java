class Solution {
    int max=0;
    int count =1;
    TreeNode prev =null;
    private void inorder(TreeNode node ,List<TreeNode> list){
        if (node == null) return ;
        inorder(node.left,list);
        if(prev !=null){
            if(node.val == prev.val) 
                count++;
            else 
                count =1;
        }
        if(count > max){
            list.clear();
            list.add(node);
            max = count;
        }
        else if(count == max){
            list.add(node);
        }
        prev =node;
        inorder(node.right,list);
    }
    public int[] findMode(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root,list);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i).val;
        }
        return res;
    }
}

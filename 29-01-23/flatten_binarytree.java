class Solution {
    TreeNode temp = null;
    public void flatten(TreeNode root) {
        if(root == null)  return ;
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right=temp;
        temp=root;
        
        
    }
}

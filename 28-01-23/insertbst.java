class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root==null)
            return newNode;
        if(val<root.val)
            root.left= insertIntoBST(root.left,val);
        if(val>root.val)
            root.right= insertIntoBST(root.right,val);
        return root;
        
        
    }
}

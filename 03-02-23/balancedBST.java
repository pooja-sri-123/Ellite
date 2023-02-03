class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode inorder(TreeNode root){
        if(root == null ) return null;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
        return root;
    }
    public TreeNode constructBST(TreeNode root , int left ,int right){
        if(left > right ) return null;
        int mid=(left + right) /2 ;
        root = list.get(mid);
        root.left = constructBST(root.left,left,mid-1);
        root.right = constructBST(root.right,mid+1,right);
        return root;
            }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return constructBST(root , 0 ,list.size()-1);
        
    }
}

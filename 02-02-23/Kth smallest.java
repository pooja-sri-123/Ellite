class Solution {
    public ArrayList<Integer>inorder(TreeNode root,ArrayList<Integer>a){
        if(root == null) return a;
        inorder(root.left,a);
        a.add(root.val);
        inorder(root.right,a);
        return a;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder( root,new ArrayList<Integer>());
        return nums.get(k-1);

        
    }
}

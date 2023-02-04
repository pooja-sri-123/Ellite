class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        preorder(root1,list);
        preorder(root2,list);
        Collections.sort(list) ;
        return list;
        }
    public void preorder(TreeNode root , List<Integer> list2){
        if(root == null) return;
        list2.add(root.val);
        preorder(root.left,list2);
        preorder(root.right,list2);
    }
}

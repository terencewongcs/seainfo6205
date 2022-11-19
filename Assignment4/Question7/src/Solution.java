class Solution {
    private boolean isFound = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root,p,null);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode successor){
        if(node==null) return successor;

        TreeNode left = helper(node.left,p, successor);

        if(isFound){
            successor = node;
            isFound = false;
        }
        if(node == p) isFound =true;

        TreeNode right = helper(node.right,p, successor);
        return left == null ? right : left;
    }
}
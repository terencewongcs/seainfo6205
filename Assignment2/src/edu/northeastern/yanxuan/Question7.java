package edu.northeastern.yanxuan;

public class Question7 {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return res;
    }

    public void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (containNode(root, p) && containNode(root,q)) {
            res = root;
        }

        traverse(root.left, p, q);
        traverse(root.right, p, q);
    }
    public boolean containNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root.val == p.val) return true;
        return containNode(root.left, p) || containNode(root.right, p);
    }
}

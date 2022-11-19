class Solution {
    public boolean isValidBST(TreeNode root) {
        return root == null || isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer lowerLimit, Integer upperLimit) {
        if (node == null) {
            return true;
        }
        if (lowerLimit != null && node.val <= lowerLimit) {
            return false;
        }
        if (upperLimit != null && node.val >= upperLimit) {
            return false;
        }
        return isValid(node.left, lowerLimit, node.val) && isValid(node.right, node.val, upperLimit);
    }
}
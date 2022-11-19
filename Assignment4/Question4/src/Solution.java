class Solution {
    TreeNode start, mid, end, prev;
    public void recoverTree(TreeNode root) {
        start = mid = end = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        if(start != null && end != null){
            int temp = start.val;
            start.val = end.val;
            end.val = temp;
        }else if(start != null && mid != null){
            int temp = start.val;
            start.val = mid.val;
            mid.val = temp;
        }
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        if(prev != null && prev.val>root.val){
            if(start==null){
                start = prev;
                mid = root;
            }else{
                end =root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}
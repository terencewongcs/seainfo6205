package edu.northeastern.yanxuan;

public class Question6 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxWidth = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,0,0);
        return maxWidth;
    }

    public void dfs(TreeNode root, int depth, int position){
        if(root == null)return;
        if(!map.containsKey(depth)){
            map.put(depth,position);
        }
        maxWidth = Math.max(maxWidth, position-map.get(depth)+1);
        dfs(root.left, depth+1, 2*position);
        dfs(root.right,depth+1, 2*position+1);
    }
}

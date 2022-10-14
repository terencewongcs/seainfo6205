package edu.northeastern.yanxuan;

public class Question3 {
    List<Integer> rightview=new ArrayList<Integer>();
    int level=0;
    int maxlevel=0;
    public List<Integer> rightSideView(TreeNode root) {
        rview(root,level+1);
        return rightview;
    }
    public void rview(TreeNode root,int level)
    {
        if(root==null)
            return;
        else if(root!=null && level>maxlevel)
        {
            maxlevel=level;
            rightview.add(root.val);
        }
        rview(root.right,level+1);
        rview(root.left,level+1);

    }
}

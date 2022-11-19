public class Codec {
    public void helper(TreeNode node,StringBuilder str){
        if(node==null){
            str.append("#"+" ");
            return ;
        }

        str.append(node.val+" ");
        helper(node.left,str);
        helper(node.right,str);
    }
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        helper(root,str);

        return str.toString();
    }

    public TreeNode dhelper(String[] arr,int []idx){
        if(idx[0]>arr.length || arr[idx[0]].equals("#")){
            idx[0]++;
            return null;
        }
        int i=idx[0];
        idx[0]++;
        int val=Integer.parseInt(arr[i]);

        TreeNode left=dhelper(arr,idx);
        TreeNode right=dhelper(arr,idx);

        TreeNode node=new TreeNode(val);

        node.left=left;
        node.right=right;


        return node;

    }
    public TreeNode deserialize(String data) {
        String arr[]=data.split(" ");
        int idx[]=new int[1];
        return dhelper(arr,idx);
    }
}
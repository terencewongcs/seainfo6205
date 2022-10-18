package edu.northeastern.yanxuan;

public class Question8 {
    Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    public int height(TreeNode root)
    {
        if (root == null)
            return -1;
        int leftHeight = height(root.left);

        int rightHeight = height(root.right);
        int ans = Math.max(leftHeight, rightHeight) + 1;
        if(!map.containsKey(ans))
            map.put(ans, new ArrayList<>(Arrays.asList(new Integer[] { root.val })));
        else
            map.get(ans).add(root.val);
        return ans;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        int x = height(root);
        System.out.println(map);
        List<List<Integer>> result = new ArrayList<>();
        for(Integer key : map.keySet())
            result.add(map.get(key));
        return result;

    }
}

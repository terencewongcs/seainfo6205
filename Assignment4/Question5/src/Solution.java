class BSTIterator {
    ArrayList<Integer> arr = new ArrayList<>();
    int curr = 0;

    public BSTIterator(TreeNode root) {
        iterator(root);
    }

    private void iterator(TreeNode root){
        if (root == null) return;
        iterator(root.left);
        arr.add(root.val);
        iterator(root.right);
    }

    public int next() {
        int val = arr.get(curr);
        curr++;
        return val;
    }

    public boolean hasNext() {
        if (curr <arr.size()) return true;
        return false;
    }
}
    Second Solution:
        Using Stack
        Time Complexity: O(h)

class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        stack.add(root);
        while (root.left != null){
            stack.add(root.left);
            root = root.left;
        }

    }

    public int next() {
        if (stack.isEmpty()) return 0;
        TreeNode temp = stack.pop();
        int result = temp.val;
        if (temp.right != null){
            temp = temp.right;
            stack.add(temp);
            while (temp.left != null){
                stack.add(temp.left);
                temp = temp.left;
            }
        }
        return result;
    }

    public boolean hasNext() {
        return (!stack.isEmpty());
    }
}
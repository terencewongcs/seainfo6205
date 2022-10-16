import java.util.ArrayDeque;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isEqual(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.value != q.value) return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!isEqual(p, q)) return false;

        ArrayDeque<TreeNode> dequeP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> dequeQ = new ArrayDeque<TreeNode>();
        dequeP.addLast(p);
        dequeQ.addLast(q);

        while (!dequeP.isEmpty()) {
            p = dequeP.removeFirst();
            q = dequeQ.removeFirst();

            if (!isEqual(p, q)) return false;
            if (p != null) {
                if (!isEqual(p.left, q.left)) return false;
                if (p.left != null) {
                    dequeP.addLast(p.left);
                    dequeQ.addLast(q.left);
                }
                if (!isEqual(p.right, q.right)) return false;
                if (p.right != null) {
                    dequeP.addLast(p.right);
                    dequeQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}

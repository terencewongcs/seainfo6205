import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public boolean isEqual(Node p, Node q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.data != q.data) return false;
        return true;
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (!isEqual(p, q)) return false;

        Queue<Node<T>> queueP = new LinkedList<>();
        Queue<Node<T>> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty()) {
            p = queueP.remove();
            q = queueQ.remove();

            if (!isEqual(p, q)) return false;
            if (p != null) {
                if (!isEqual(p.left, q.left)) return false;
                if (p.left != null) {
                    queueP.add(p.left);
                    queueQ.add(q.left);
                }
                if (!isEqual(p.right, q.right)) return false;
                if (p.right != null) {
                    queueP.add(p.right);
                    queueQ.add(q.right);
                }
            }
        }
        return true;
    }
}
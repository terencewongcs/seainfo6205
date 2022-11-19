class Solution {

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node head = root;
        while (head.left != null) {
            head = head.left;
        }

        Node tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }

        postorder(root, null);

        tail.right = head;
        head.left = tail;
        return head;
    }

    public void postorder(Node node, Node prev) {
        if (node != null) {

            if (node.left != null)
                postorder(node.left, node);

            if (node.right != null)
                postorder(node.right, node);

            if (prev != null && prev.left == node) {
                Node temp = getRight(node);
                temp.right = prev;
                prev.left = temp;
            }


            if (prev != null && prev.right == node) {
                Node temp = getLeft(node);
                temp.left = prev;
                prev.right = temp;
            }
        }
    }

    public Node getRight(Node cur) {
        while (cur.right != null)
            cur = cur.right;

        return cur;
    }

    public Node getLeft(Node cur) {
        while (cur.left != null)
            cur = cur.left;

        return cur;
    }
}
package edu.northeastern.yanxuan;

public class Question5 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }

        // locate the root node
        Node root = null;
        Node prev = head;
        Node cur = head.next;
        while (cur != head) {
            if (prev.val > cur.val) { // e.g. 5 -> 1
                root = cur;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        // case like [3, 3, 3]
        root = root==null ? head:root;

        // insert the new node
        prev = root;
        cur = root.next;
        boolean done = false;
        while (cur != root) {
            // case 1
            if (prev.val <= insertVal && insertVal <= cur.val) {
                prev.next = node;
                node.next = cur;
                done = true;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        // all other cases (2 & 3)
        if (!done) {
            node.next = cur;
            prev.next = node;
        }

        return head;
    }

}

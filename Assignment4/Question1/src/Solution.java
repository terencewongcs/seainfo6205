class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode slow = head, fast = head, slowPrev = null;
        while(fast!=null && fast.next!=null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        if(slowPrev==null){
            return new TreeNode(slow.val);
        }
        slowPrev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(temp);
        return root;
    }
}
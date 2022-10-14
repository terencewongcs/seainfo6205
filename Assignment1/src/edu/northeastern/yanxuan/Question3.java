package edu.northeastern.yanxuan;

public class Question3 {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        int length = 0;

        while(curr != null) {
            if(++length == k) prev = curr;
            curr = curr.next;
        }

        curr = head;
        length = length - k;

        while(length-- > 0) curr = curr.next;

        int temp = prev.val;
        prev.val = curr.val;
        curr.val = temp;

        return head;
    }
}

package edu.northeastern.yanxuan;

public class Question4 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode[] result = new ListNode[k];
        ListNode curr = head, dummy = new ListNode(-1), node = null;

        while(curr != null) {
            count++;
            curr = curr.next;
        }

        int remainder = count % k;
        int slots = count / k;
        curr = head;
        int index = 0;

        while(index < k && curr != null) {
            count = slots;
            dummy = new ListNode(-1);
            node = dummy;

            while(curr != null && count > 0) {
                node.next = curr;
                node = node.next;
                curr = curr.next;
                count--;
            }

            if(remainder > 0) {
                node.next = curr;
                node = node.next;
                curr = curr.next;
                remainder--;
            }

            node.next = null;
            result[index++] = dummy.next;
        }

        while(index < k) {
            if(curr != null) {
                node = curr;
                curr = curr.next;
                node.next = null;
                result[index++] = node;
            } else{
                result[index++] = null;
            }
        }

        return result;
    }
}

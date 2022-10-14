package edu.northeastern.yanxuan;

public class Question2 {
    public ListNode removeElements(ListNode head, int val) {
        if(head== null) return head;
        ListNode curr = null;
        ListNode mHead = null;
        int i =0;
        while(head!= null)
        {
            if(head.val == val)
            {
                if(curr != null) curr.next = head.next;
                head = head.next;
            }
            else
            {
                if(i == 0)
                {
                    mHead = head;
                    i++;
                }
                curr = head;
                head = head.next;
            }
        }
        return mHead;
    }
}

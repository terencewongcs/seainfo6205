package edu.northeastern.yanxuan;

public class Question1 {
    public ListNode rotateRight(ListNode head, int k) {
        if( head==null || head.next==null ) return head;

        int size=1;
        ListNode trav = head;

        //find size of list
        while(trav.next!=null){
            size++;
            trav=trav.next;
        }

        k=k%size;
        trav.next=head;

        while((size-k)>0){
            head=head.next;
            trav=trav.next;
            k++;
        }
        trav.next=null;

        return head;

    }
}

package com.company.LinkedList;

/**
 * Created by rmandada on 24/3/16.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(1);
        ListNode z = new ListNode(1);
        ListNode p = new ListNode(1);
        x.next = y;
        y.next = z;
        z.next = p;
        System.out.println(deleteDuplicates(x).val);
    }

    public static ListNode deleteDuplicates(ListNode a) {
        ListNode tmp = new ListNode(0);
        tmp.next = a;

        ListNode p = tmp;

        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int d = p.next.val;
                while (p.next != null && p.next.val == d) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }

        return tmp.next;
    }
}

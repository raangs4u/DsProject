package com.company.LinkedList;

/**
 * Created by RANGA on 3/25/2016.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;
        System.out.println(reorderList(a));
    }

    public static ListNode reorderList(ListNode a) {
        int l = listLength(a);
        l = l/2;

        ListNode tmp = a;

        while(l>0) {
            l--;
            tmp = tmp.next;
        }

        ListNode x = reverseList(tmp.next);
        tmp.next = null;
        if(x == null) {
            return a;
        }
        ListNode t = a;
        while(x!=null) {
            ListNode y = x.next;
            x.next = t.next;
            t.next = x;
            x = y;
            t = t.next.next;
        }

        return a;
    }

    public static int listLength(ListNode a) {
        int x = 0;
        ListNode tmp = a;

        while(tmp!=null) {
            x++;
            tmp = tmp.next;
        }

        return x;
    }

    public static ListNode reverseList(ListNode a) {
        ListNode prev = null;
        ListNode current = a;
        ListNode next = null;

        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

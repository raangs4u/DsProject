package com.company.LinkedList;

/**
 * Created by rmandada on 24/3/16.
 */
public class Palindrome {

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
       /* ListNode y = new ListNode(2);
        ListNode z = new ListNode(1);
        x.next = y;
        y.next = z;*/

        System.out.println(lPalin(x));
    }

    public static int lPalin(ListNode A) {
        int m = listLength(A);
        boolean even = (m%2 ==0);
        m = m/2;
        ListNode mid = A;
        while(m>0) {
            m--;
            mid = mid.next;
        }

        ListNode secondHalf ;

        if (even) {
            secondHalf = reverseList(mid);
        } else {
            secondHalf= reverseList(mid.next);
        }

        while(A != null && secondHalf!=null) {
            if(A.val != secondHalf.val) {
                return 0;
            }
            A = A.next;
            secondHalf = secondHalf.next;
        }

        return 1;

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

    public static int listLength(ListNode a) {
        int x = 0;
        ListNode tmp = a;

        while(tmp!=null) {
            x++;
            tmp = tmp.next;
        }

        return x;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}

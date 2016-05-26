package com.company.LinkedList;

import java.util.Stack;

/**
 * Created by RANGA on 3/25/2016.
 */
public class SumTwoLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);

        a.next = b;
        b.next = c;
        ListNode d = new ListNode(1);
        System.out.println(addTwoNumbers(d,a));
    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode t1 = a;
        ListNode t2 = b;
        ListNode s = null;
        ListNode h = null;
        int carry = 0;
        while(t1!=null && t2!=null) {
            int sum = carry + t1.val + t2.val;
            carry = sum /10;
            sum = sum % 10;

            ListNode x = new ListNode(sum);
            if(h==null) {
                h = x;
                s = x;
            } else {
                s.next = x;
                s = x;
            }

            t1 = t1.next;
            t2 = t2.next;
        }


        if(t1 != null) {

            while(t1!=null) {
                int sum = carry + t1.val;
                carry = sum /10;
                sum = sum % 10;

                ListNode x = new ListNode(sum);
                if(h==null) {
                    h = x;
                    s = x;
                } else {
                    s.next = x;
                    s = x;
                }

                t1 = t1.next;
            }
            /*Stack s = new Stack();
            s.*/
        } else {
            while(t2!=null) {
                int sum = carry + t2.val;
                carry = sum /10;
                sum = sum % 10;

                ListNode x = new ListNode(sum);
                if(h==null) {
                    h = x;
                    s = x;
                } else {
                    s.next = x;
                    s = x;
                }

                t2 = t2.next;
            }
        }
        if(carry !=0) {
            ListNode x = new ListNode(carry);
            s.next = x;
        }
        ListNode u = null;
        ListNode tmp = h;
        while(tmp!= null) {
            if(tmp.val != 0) {
                u = tmp;
            }
            tmp = tmp.next;
        }
        if(u==null) {
            return u;
        }
        u.next = null;

        return h;

    }
}

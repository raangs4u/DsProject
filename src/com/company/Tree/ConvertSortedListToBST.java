package com.company.Tree;

import com.company.LinkedList.ListNode;

/**
 * @author rmandada
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode a) {
        ListNode middle  = middleNode(a);
        TreeNode root = new TreeNode(middle.val);
        if (a== middle) {
            return root;
        } else {
            root.left = sortedListToBST(a);
            if (middle.next!=null) {
                root.right = sortedListToBST(middle.next);
            }
        }
        return root;
    }

    public ListNode middleNode(ListNode root) {
        int count = 0;
        if (root==null || root.next==null) {
            return root;
        }
        ListNode temp = root;
        while (temp!=null) {
            count++;
            temp= temp.next;
        }
        temp = root;
        count = count/2 -1;
        while (count >0) {
            temp = temp.next;
            count--;
        }
        ListNode x = temp.next;
        temp.next = null;
        return x;
    }
}

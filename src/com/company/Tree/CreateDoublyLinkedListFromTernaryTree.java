package com.company.Tree;

/**
 * @author rmandada
 */
public class CreateDoublyLinkedListFromTernaryTree {

    class TernaryTreeNode {
        int val;
        TernaryTreeNode left;
        TernaryTreeNode middle;
        TernaryTreeNode right;
    }

    public TernaryTreeNode ternaryTreeToList(TernaryTreeNode root, TernaryTreeNode head, TernaryTreeNode tail) {
        if (root == null) {
            return null;
        }

        if (head == null) {
            head = root;
        }

        tail = push(tail, root);
        ternaryTreeToList(root.left, head, tail);
        ternaryTreeToList(root.middle, head, tail);
        ternaryTreeToList(root.right, head, tail);
        return head;
    }

    public TernaryTreeNode push(TernaryTreeNode tail, TernaryTreeNode node) {
        if (tail == null) {
            node.left = null;
            node.right = null;
            node.middle = null;
            tail = node;
            return tail;
        }
        node.left = node.right = node.middle = null;
        node.left = tail;
        tail.right = node;
        tail = node;
        return tail;
    }
}

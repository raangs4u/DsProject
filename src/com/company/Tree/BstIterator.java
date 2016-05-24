package com.company.Tree;

import java.util.Stack;

/**
 * @author RANGA.
 */
public class BstIterator {

    Stack<TreeNode> s1 = new Stack<TreeNode>();

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        BstIterator iterator = new BstIterator(n1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public BstIterator(TreeNode root) {
        addNext(root);
    }

    public void addNext(TreeNode root) {
        TreeNode current = root;
        while (current!=null) {
            s1.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s1.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = s1.pop();
        addNext(node.right);
        return node.val;
    }
}

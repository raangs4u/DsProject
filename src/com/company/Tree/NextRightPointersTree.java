package com.company.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rmandada
 */
public class NextRightPointersTree {

    static class TreeLinkNode {

        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        n3.right = n4;
        n3.left = n2;
        n2.left = n1;
        n4.right = n5;
        connectUsingQueue(n3);
    }

    public static void connectUsingQueue(TreeLinkNode root) {
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        TreeLinkNode prev=null;
        int nodeCount;
        while (!queue.isEmpty()) {
            nodeCount = queue.size();
            while (nodeCount >0) {
                TreeLinkNode node = queue.pop();
                nodeCount--;

                if (nodeCount>0) {
                    node.next = queue.peekFirst();
                }

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
    }

    public static void connectUsingRecursion(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.next != null) {
            connectUsingRecursion(root.next);
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
                root.right.next = getNextRight(root);
            } else {
                root.left.next = getNextRight(root);
            }
            connectUsingRecursion(root.left);
        } else if (root.right != null) {
            root.right.next = getNextRight(root);
            connectUsingRecursion(root.right);
        } else {
            connectUsingRecursion(getNextRight(root));
        }
    }

    public static void connectUsingConstantSpace(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        root.next = null;

        while (root!= null) {

            TreeLinkNode t = root;

            while (t!=null) {
                if (t.left != null) {
                    if (t.right != null) {
                        t.left.next = t.right;
                        //t.right.next = getNextRight(t);
                    } else {
                        t.left.next = getNextRight(t);
                    }
                }

                if (t.right != null) {
                    t.right.next = getNextRight(root);
                }

                t = t.next;
            }

            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = getNextRight(root);
            }
        }
    }

    public static TreeLinkNode getNextRight(TreeLinkNode node) {
        TreeLinkNode temp = node.next;

        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            }

            if (temp.right != null) {
                return temp.right;
            }
            temp = temp.next;
        }

        return null;
    }
}

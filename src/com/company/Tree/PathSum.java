package com.company.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rmandada
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(-1);
        TreeNode n5 = new TreeNode(5);
        n3.left = n2;
        /*n3.right = n4;
        n3.left = n2;*/
       // n2.left = n1;
       // n4.right = n5;
        hasPathSum(n3,1);
    }

    public static int hasPathSum(TreeNode a, int b) {
        /*Stack<TreeNode> stack = new Stack<>();
        //stack.push(a);
        int sum = 0;
        TreeNode current = a;
        while (!stack.isEmpty() || current != null) {
            if (current.left != null || current.right != null) {
                stack.push(current);
                sum += current.val;
                if (current.left!=null) {
                    current = current.left;
                } else {
                    current = current.right;
                }

            } else {
                if (sum+current.val == b) {
                    return 1;
                }
                if (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    if (node.right != null) {
                        current = node.right;
                    } else {
                        if (!stack.isEmpty()) {
                            sum -= node.val;
                            TreeNode node1 = stack.pop();
                            current = node1.right;
                        } else {
                            return 0;
                        }
                    }
                } else {
                    return 0;
                }

            }
        }

        return 0;*/
        if(a==null) {
            if(b==0) {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;
        int subSum = b-a.val;
        if(subSum ==0 && a.left == null && a.right == null) {
            return 1;
        }
        if(a.left != null) {
            if((ans == 1) || hasPathSum(a.left, subSum) == 1) {
                ans = 1;
            }

        }
        if(a.right != null) {
            if((ans == 1) || hasPathSum(a.right, subSum) == 1) {
                ans = 1;
            }
        }




        return ans;
    }
}

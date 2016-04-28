package com.company.Tree;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author rmandada
 */
public class RecoverBst {

    public ArrayList<Integer> recoverTree(TreeNode a) {
        TreeNode current, prev, node1=null, node2=null, first=null, second=null;
        current = a;

        while (current!=null) {
            if (current.left == null) {
                if (node1 == null) {
                    node1 = current;
                } else if (node2 == null) {
                    node2 = current;
                } else {
                    node1 = node2;
                    node2 = current;
                }
                current = current.right;
            } else {
                prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                    continue;
                } else {
                    prev.right = null;
                    if (node2 == null) {
                        node2 = current;
                    } else {
                        node1 = node2;
                        node2 = current;
                    }
                    current = current.right;
                }
            }

            if (node1!= null && node2!=null && node1.val > node2.val) {
                if (first == null) {
                    first = node1;
                }
                second = node2;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(Math.min(first.val, second.val));
        res.add(Math.max(first.val, second.val));
        return res;
    }
}

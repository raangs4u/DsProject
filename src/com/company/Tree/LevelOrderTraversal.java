package com.company.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author rmandada
 */
public class LevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(a);
        int nodeCount;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean reverse = false;
        while (true) {
            nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }
            ArrayList<Integer> r = new ArrayList<>();
            while (nodeCount>0) {
                TreeNode node = queue.pop();
                queue.addLast(node.left);
                queue.addLast(node.right);
                r.add(node.val);
                nodeCount--;
            }
            reverse = !reverse;
            res.add(r);
        }

        return res;
    }

}

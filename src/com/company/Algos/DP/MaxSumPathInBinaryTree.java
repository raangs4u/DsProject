package com.company.Algos.DP;

import com.company.Tree.TreeNode;

import java.util.HashMap;

/**
 * @author RANGA.
 */
public class MaxSumPathInBinaryTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(50);
        TreeNode g = new TreeNode(50);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println(maxPathSum(a));

    }
    public static int maxPathSum(TreeNode a) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        memo(a,map, res);
        return res[0];
    }

    public static int memo(TreeNode a, HashMap<TreeNode, Integer> map, int[] res){
        if (a==null) {
            return 0;
        }

        if (map.containsKey(a)) {
            return map.get(a);
        }

        int left = memo(a.left,map, res);
        int right = memo(a.right,map,res);
        int maxSingle = Math.max(a.val+Math.max(left,right), a.val);
        int maxTop = Math.max(maxSingle, left+right+a.val);
        res[0] = Math.max(res[0], maxTop);
        map.put(a,maxSingle);
        return maxSingle;
    }

}

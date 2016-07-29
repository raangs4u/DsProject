package com.company.Tree;

/**
 * @author rmandada
 */
public class LargestSubtreeHavingIdenticalLeftAndRightSubTrees {

    int largestSubtreeUtil(TreeNode root, TempResult result){
        if (root == null) {
            return 0;
        }

        TempResult tempResult1 = new TempResult(result.maxSize, result.maxNode, "");
        TempResult tempResult2 = new TempResult(result.maxSize, result.maxNode, "");
        int lr = largestSubtreeUtil(root.left, tempResult1);
        int rr = largestSubtreeUtil(root.right, tempResult2);

        int size = lr + rr + 1;
        if (tempResult1.str == tempResult2.str) {
            if (size > result.maxSize) {
                result.maxSize = size;
                result.maxNode = root;
            }
        }

        result.str += "|"+tempResult1.str + "|";
        result.str += "|" + root.val + "|";
        result.str += "|" + tempResult2.str + "|";

        return size;
    }

    class TempResult {
        int maxSize;
        TreeNode maxNode;
        String str;

        public TempResult(int maxSize, TreeNode maxNode, String str) {
            this.maxSize = maxSize;
            this.maxNode = maxNode;
            this.str = str;
        }
    }
}

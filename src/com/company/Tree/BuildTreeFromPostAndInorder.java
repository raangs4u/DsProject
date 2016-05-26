package com.company.Tree;

import java.util.ArrayList;

/**
 * @author RANGA.
 */
public class BuildTreeFromPostAndInorder {

    public TreeNode buildTree(ArrayList<Integer> postorder, ArrayList<Integer> inorder) {
        if (postorder.size() == 0 || inorder.size()==0) {
            return null;
        }

        return temp(postorder, 0, postorder.size()-1, inorder, 0, inorder.size()-1);
    }

    public TreeNode temp(ArrayList<Integer> postorder, int pi, int pj, ArrayList<Integer> inorder, int ii, int ij) {
        if (pi == pj) {
            return new TreeNode(postorder.get(pi));
        }

        if (pi >pj) {
            return null;
        }

        TreeNode root = new TreeNode(postorder.get(pj));
        int rootIdxInorder = -1;
        for (int i = ii; i <=ij ; i++) {
            if(inorder.get(i)==root.val) {
                rootIdxInorder = i;
                break;
            }
        }
        int length = rootIdxInorder - ii;
        root.left = temp(postorder, pi, pi+length-1, inorder, ii, rootIdxInorder-1);
        root.right = temp(postorder,pi+length,pj-1, inorder, rootIdxInorder+1, ij);
        return root;
    }
}

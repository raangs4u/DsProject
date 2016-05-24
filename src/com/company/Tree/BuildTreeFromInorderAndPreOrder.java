package com.company.Tree;

import java.util.ArrayList;

/**
 * @author RANGA.
 */
public class BuildTreeFromInorderAndPreOrder {
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size()==0) {
            return null;
        }

        return temp(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1);
    }

    public TreeNode temp(ArrayList<Integer> preorder, int pi, int pj, ArrayList<Integer> inorder, int ii, int ij) {
        if (pi == pj) {
            return new TreeNode(preorder.get(pi));
        }

        if (pi >pj) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(pi));
        int rootIdxInorder = -1;
        for (int i = ii; i <=ij ; i++) {
            if(inorder.get(i)==root.val) {
                rootIdxInorder = i;
                break;
            }
        }
        int length = rootIdxInorder - ii;
        root.left = temp(preorder, pi+1, pi+length, inorder, ii, rootIdxInorder-1);
        root.right = temp(preorder,pi+length+1,pj, inorder, rootIdxInorder+1, ij);
        return root;
    }
}

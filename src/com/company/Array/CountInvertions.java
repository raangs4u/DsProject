package com.company.Array;

/**
 * @author rmandada
 */
public class CountInvertions {
    public static void main(String[] args) {
        int arr[] = {1, 20, 6, 4, 5};
        int[] res = {0};

        System.out.println(byAVLTreeMethod(arr));
    }

    public static int byMergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }

    public static int  mergeSort(int[] arr, int l, int r) {
        int res = 0;
        if (l<r) {
            int m = (l+r)/2;
            res+=mergeSort(arr, l, m);
            res+=mergeSort(arr, m+1,r);
            res+=merge(arr, l, m, r);
        }
        return res;
    }

    public static int merge(int[] arr, int l, int m, int r) {
        //int i,j,k;
        int res = 0;
        int n1 = m-l+1;
        int n2 = r-m;

        int L[] = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i <n1 ; i++) {
            L[i]= arr[l+i];
        }
        for (int i = 0; i <n2 ; i++) {
            R[i] = arr[m+1+i];
        }
        int i=0,j=0,k=l;

        while (i<n1 && j<n2) {
            if (L[i]<=R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                res+= (n1-i);
                j++;
            }
            k++;
        }

        while (i<n1) {
            arr[k] = L[i];
            i++;
            k++;
            //res[0]++;
        }

        while (j<n2) {
            arr[k]=R[j];
            j++;
            k++;
        }

        return res;
    }

    public static int byAVLTreeMethod(int[] arr) {
        int n = arr.length;
        AVLTreeNode root = null;
        int[] res ={0};
        for (int i = 0; i <n ; i++) {
            root = insertInAVLTree(root, arr[i], res);
        }
        return res[0];
    }

    static class AVLTreeNode {
        int key, height;
        int size; // size of the tree rooted with this node
        AVLTreeNode left, right;

        public AVLTreeNode(int key) {
            this.key = key;
            this.height=1;
            this.size=1;
        }
    }

    public static int height(AVLTreeNode node) {
        if (node==null) {
            return 0;
        }
        return node.height;
    }

    public static int size(AVLTreeNode node) {
        if (node==null) {
            return 0;
        }
        return node.size;
    }

    public static int getBalance(AVLTreeNode node) {
        if (node==null) {
            return 0;
        }
        return height(node.left)-height(node.right);
    }

    public static AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        x.height = Math.max(height(x.left), height(x.right)) +1;
        y.height = Math.max(height(y.left), height(y.right)) +1;

        return x;
    }

    public static AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;

        x.right = T2;
        y.left = x;

        x.height = Math.max(height(x.left), height(x.right)) +1;
        y.height = Math.max(height(y.left), height(y.right)) +1;

        return y;
    }

    public static AVLTreeNode insertInAVLTree(AVLTreeNode node, int key, int[] res) {
        if (node == null) {
            return new AVLTreeNode(key);
        }

        if (key < node.key) {
            node.left = insertInAVLTree(node.left, key, res);
            res[0] += size(node.right) +1;
        } else {
            node.right = insertInAVLTree(node.right, key, res);
        }

        node.height = Math.max(height(node.left), height(node.right)) +1;

        int balance = getBalance(node);

        // left left
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // right right
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // left right
        if (balance >1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // right left
        if (balance <-1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

}

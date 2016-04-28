package com.company.Tree;

/**
 * @author rmandada
 */
public class SegmentTrees {

    class Node {
        int left, right, value;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public void merge(Node leftChild, Node rightChild) {
            if (leftChild == null) {
                value = rightChild.value;
            } else if (rightChild == null) {
                value = leftChild.value;
            } else {
                value = Math.min(leftChild.value, rightChild.value);
            }
        }
    }

    int n;
    Node[] tree;

    public SegmentTrees(int[] a) {
        n = a.length;
        int len = (int) Math.floor(Math.log(n)/Math.log(2));
        len = (int) ( 2 * Math.pow(2, len));
        tree = new Node[len];
        build(1, 0, n-1, a);
    }

    private void build(int node, int l, int r, int[] a) {
        if (l==r) {
            tree[node] = new Node(l, r);
            tree[node].value = a[l];
            return;
        }

        int leftChild = 2 *node, mid = (l+r)/2;
        int rightChild = 2 * node + 1;
        build(leftChild, l, mid, a);
        build(rightChild, mid+1, r, a);

        tree[node] = new Node(l,r);
        tree[node].merge(tree[leftChild], tree[rightChild]);

    }

    public  int  query (int  i, int  j) {
        Node result = query( 1 , 0 , n - 1 , i, j);
        return  result.value;
    }

    private Node query(int node, int l, int r, int i, int j) {
        if (i>=l && j<= r) {
            return tree[node];
        } else if (i > r || j < l) {
            return null;
        } else {
            int  leftChild = 2 * node, rightChild = leftChild + 1 , mid = (l + r) / 2 ;
            Node a = query (leftChild, l, mid, i, j);     // visit left child
            Node b = query (rightChild, mid + 1 , r, i, j);
            Node temp = new Node(-1, -1);
            temp.merge(a,b);
            return temp;
        }
    }

    private  void  update ( int  node, int  l, int  r, int  i, int  v) {
        if  (l == r && i == l) tree [node] .value = v; // leaf node
        else  if  (i <l || i> r) return ;         // out of range
        else {  // partially within{
            int  leftChild = 2 * node, rightChild = leftChild + 1 , mid = (l + r) / 2 ;
            update (leftChild, l, mid, i, v);     // visit left child
            update (rightChild, mid + 1 , r, i, v); // right child visit
            tree [node] .merge (tree [leftChild], tree [rightChild]);
        }
    }
    public  void  update ( int  i, int  newValue)
    {
        update ( 1 , 0 , n-1 , i, newValue);
    }
}

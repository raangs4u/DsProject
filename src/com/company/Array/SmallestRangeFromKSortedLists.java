package com.company.Array;

import com.company.Tree.MinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class SmallestRangeFromKSortedLists {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}};
        System.out.println(findSmallestRange(arr, 3));
    }

    public static List<Integer> findSmallestRange(int[][] arr, int k) {
        int N = arr[0].length;
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int start=-1, end=-1;
        MinHeapNode[] initialArray = new MinHeapNode[k];
        for (int i = 0; i <k ; i++) {
            initialArray[i] = new MinHeapNode(arr[i][0], i, 1);
            if (arr[i][0] > max) {
                max = arr[i][0];
            }
        }
        MinHeap<MinHeapNode> heap = new MinHeap<MinHeapNode>(initialArray, k, 100);
        heap.buildHeap();

        while (true) {
            MinHeapNode root = heap.getMin();
            min = root.element;
            if (range > max - min +1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            if (root.j < N) {
                root.element = arr[root.i][root.j];
                root.j += 1;

                if (root.element > max) {
                    max = root.element;
                }
            } else {
                break;
            }

            heap.siftDown(0);

        }

        List<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(end);
        return res;

    }

    static class MinHeapNode implements Comparable<MinHeapNode>{

        int element;

        int i;

        int j;

        public MinHeapNode(int element, int i, int j) {
            this.element = element;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(MinHeapNode o) {
            return this.element - o.element;
        }
    }
}

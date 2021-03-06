package com.company.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rmandada
 */
public class MinHeap<E extends Comparable<E>> {
    private E[] heap;
    private Map<E, Integer> position;
    private int size;
    private int n;

    public MinHeap(E[] h, int num, int max) {
        heap = h;
        n = num;
        size = max;
        position = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            position.put(heap[i], i);
        }
    }

    public E getMin() {
        return heap[0];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int heapSize() {
        return n;
    }

    public boolean isLeaf(int pos) {
        return (pos >= n/2 && (pos <n ));
    }

    public int leftChild(int pos) {
        if (pos < n/2) {
            return 2 *pos +1;
        }

        return -1;
    }

    public int rightChild(int pos) {
        if (pos < (n-1)/2){
            return 2*pos+2;
        }

        return -1;
    }

    public int parent(int pos) {
        if (pos >0) {
            return (pos-1)/2;
        }

        return -1;
    }

    public void buildHeap() {
        for (int i = n/2 -1; i >=0 ; i--) {
            siftDown(i);
        }
    }

    public void insert(E val) {
        if (n < size) {
            int curr = n++;
            heap[curr] = val;

            siftUp(curr);
        }
    }

    public E removeMin() {
        if (n > 0) {
            swap(heap, 0, --n);
            if (n!=0) {
                siftDown(0);
            }

            return heap[n];
        }

        return null;
    }

    public E remove(int pos) {
        if (pos>=0 && pos < n) {
            if (pos == n-1) {
                n--;
            } else {
                swap(heap, pos, --n);

                siftUp(pos);

                if (n!=0) {
                    siftDown(pos);
                }
            }
        }

        return null;
    }

    public void siftUp(int pos) {
        while ((pos > 0) && (heap[pos].compareTo(heap[parent(pos)]) < 0)) {
            swap(heap, pos, parent(pos));
            pos = parent(pos);
        }
    }

    public void siftDown(int pos) {
        if (pos >=0 && pos < n) {
            while (!isLeaf(pos)) {
                int j = leftChild(pos);
                if ((j<n-1) && (heap[j].compareTo(heap[j+1]) > 0)) {
                    j++;
                }

                if (heap[pos].compareTo(heap[j]) <= 0) {
                    return;
                }

                swap(heap, pos, j);
                pos = j;
            }
        }
    }

    private void swap(E[] arr, int i, int j) {
        position.put(arr[i], j);
        position.put(arr[j], i);
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int indexOf(E v) {
        return position.containsKey(v) ? position.get(v) : -1;
    }

}

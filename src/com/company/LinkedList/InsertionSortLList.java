package com.company.LinkedList;

/**
 * Created by RANGA on 1/14/2015.
 */
public class InsertionSortLList {

    public static void main(String[] args) {

    }

    public static void sort(DLinkedList list) {
        if (list.getSize()<=1) return;
        DNode pivot;
        DNode ins;
        DNode end = list.getFirst();

        while (end!=list.getLast()) {
            pivot = end.getNext();
            list.remove(pivot);
            ins = end;


        }
    }
}

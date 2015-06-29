package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmandada on 26/6/15.
 */
public class RemoveDuplicatesInUnsortedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(5);

        removeDuplicatesByHashing(list.getHead());
        list.printList();
    }

    public static void removeDuplicatesByTwoLoops(Node<Integer> head) {
        /**
         * Straight forward implementation using two loops
         */
    }

    public static void removeDuplicatesBySorting(Node<Integer> head) {
        /**
         * Will implement after implementing merge sort
         */
    }

    public static void removeDuplicatesByHashing(Node<Integer> head) {

        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        Node<Integer> current = head;

        Node<Integer> prev = null;

        while (current!=null) {
            if(hashMap.containsKey(current.getElement())) {
                prev.setNext(current.getNext());
                current = current.getNext();
            } else {
                hashMap.put(current.getElement(), 1);
                prev = current;
                current = current.getNext();
            }
        }
    }
}

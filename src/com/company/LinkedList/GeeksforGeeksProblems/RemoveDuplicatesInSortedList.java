package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 26/6/15.
 */
public class RemoveDuplicatesInSortedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(5);
        removeDuplicates(list.getHead());
        list.printList();
    }

    public static void removeDuplicates(Node<Integer> head) {
        Node<Integer> current = head;

        while (current.getNext()!=null) {
            if(current.getElement() == current.getNext().getElement()) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }
}

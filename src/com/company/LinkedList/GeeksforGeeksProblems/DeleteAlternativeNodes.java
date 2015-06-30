package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 30/6/15.
 */
public class DeleteAlternativeNodes {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 7; i >0 ; i--) {
            list.addFirst(i);
        }

        //deleteAlternativeNodesByIterative(list.getHead());
        deleteAlternativeNodesByRecursive(list.getHead());
        list.printList();
    }

    public static void deleteAlternativeNodesByIterative(Node<Integer> head) {
        while (head!= null && head.getNext() != null) {
            head.setNext(head.getNext().getNext());
            head = head.getNext();
        }
    }

    public static void deleteAlternativeNodesByRecursive(Node<Integer> head) {
        if (head == null || head.getNext() == null) return;

        head.setNext(head.getNext().getNext());
        deleteAlternativeNodesByRecursive(head.getNext());
    }
}

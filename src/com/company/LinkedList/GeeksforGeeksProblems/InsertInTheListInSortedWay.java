package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 24/6/15.
 */
public class InsertInTheListInSortedWay {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        list.setHead(ReverseLinkedList.reverseByIterative(list.getHead()));
        Node<Integer> node = new Node<Integer>(5, null);
        Node<Integer> head = insert(list.getHead(), node);
        list.setHead(head);
        list.printList();
    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> newNode) {
        if(newNode == null) return head;

        if(head == null || head.getElement()>= newNode.getElement()) {
            newNode.setNext(head);
            head = newNode;
            return head;
        }
        Node<Integer> current = head;
        while (current.getNext()!=null && current.getNext().getElement() < newNode.getElement()) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        return head;
    }
}

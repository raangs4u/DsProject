package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/26/2015.
 */
public class MoveLastElementToFirst {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        Node<Integer> head = moveLastToFirst(list.getHead());
        list.setHead(head);
        list.printList();
    }
    public static Node<Integer> moveLastToFirst(Node<Integer> head) {
        Node<Integer> current = head;
        while (current!=null && current.getNext()!=null) {
            current = current.getNext();
        }

        current.getNext().setNext(head);
        head = current.getNext();
        current.setNext(null);
        return head;
    }
}

package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/23/2015.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <5 ; i++) {
            list.addFirst(i);
        }

        //Node<Integer> head = reverseByRecursive(list.getHead());
        //list.printList();
        //Node<Integer> head = reverseByIterative(list.getHead());
        /*list.setHead(head);
        list.printList();
        head = reverseByCreatingNewList(list.getHead());
        list.setHead(head);
        list.printList();*/

        printReverseOfListByRecursive(list.getHead());

    }

    public static Node<Integer> reverseByIterative(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> prev = null;
        Node<Integer> next;

        while (current!=null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return prev;
    }

    public static Node<Integer> reverseByCreatingNewList(Node<Integer> head) {
        Node<Integer> newHead = null;
        Node<Integer> current = head;

        while (current != null) {
            Node<Integer> tmp = current;
            current = current.getNext();
            tmp.setNext(null);

            if(newHead == null) {
                newHead = tmp;
            } else {
                tmp.setNext(newHead);
                newHead = tmp;
            }
        }

        return newHead;
    }

    public static Node<Integer> reverseByRecursive(Node<Integer> head) {
        Node<Integer> first;
        Node<Integer> rest;

        if(head == null) {
            return head;
        }

        first = head;
        rest = head.getNext();

        if(rest == null){
            return head;
        }

        rest = reverseByRecursive(rest);
        first.getNext().setNext(first);
        first.setNext(null);
        return rest;
    }

    public static void printReverseOfListByRecursive(Node<Integer> head) {
        if (head == null) return;
        printReverseOfListByRecursive(head.getNext());
        System.out.println(head.getElement());
    }
}

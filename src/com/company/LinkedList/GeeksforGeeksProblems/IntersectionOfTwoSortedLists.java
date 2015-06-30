package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 30/6/15.
 */
public class IntersectionOfTwoSortedLists {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list1.addFirst(4-i);
        }

        //printList(list1.getHead());
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        for (int i = 7; i >2 ; i--) {
            list2.addFirst(i);
        }

        //printList(list2.getHead());
        //Node<Integer> head = intersectionOfTwoSortedLists(list1.getHead(),list2.getHead());
        Node<Integer> head = intersectionOfTwoSortedListsByRecursion(list1.getHead(),list2.getHead());
        printList(head);
    }

    public static Node<Integer> intersectionOfTwoSortedLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummy = new Node<Integer>(-1,null);
        Node<Integer> tail = null;
        while (head1 != null && head2!= null) {
            if(head1.getElement() == head2.getElement()) {
                Node<Integer> node = new Node<Integer>(head1.getElement(),null);
                if(tail == null) {
                    dummy.setNext(node);
                    tail = node;
                } else {
                    tail.setNext(node);
                    tail = node;
                }
                head1 = head1.getNext();
                head2 = head2.getNext();
            } else if(head1.getElement() < head2.getElement()) {
                head1 = head1.getNext();
            } else {
                head2 = head2.getNext();
            }
        }
        return dummy.getNext();
    }

    public static Node<Integer> intersectionOfTwoSortedListsByRecursion(Node<Integer> head1, Node<Integer> head2) {
        if(head1==null || head2==null) {
            return null;
        }

        if(head1.getElement() < head2.getElement()) {
            return intersectionOfTwoSortedListsByRecursion(head1.getNext(), head2);
        }

        if(head1.getElement() > head2.getElement()) {
            return intersectionOfTwoSortedListsByRecursion(head1, head2.getNext());
        }

        Node<Integer> tmp = new Node<Integer>(head1.getElement(),null);
        tmp.setNext(intersectionOfTwoSortedListsByRecursion(head1.getNext(),head2.getNext()));
        return tmp;
    }

    public static void  printList(Node<Integer> head) {
        Node<Integer> tmp = head;
        while (tmp!=null) {
            System.out.println(tmp.getElement());
            tmp = tmp.getNext();
        }
    }
}

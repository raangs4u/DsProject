package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 30/6/15.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();

        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(9);
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);

        Node<Integer> merged = merge(list1.getHead(), list2.getHead());

        printList(merged);
    }

    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummy = new Node<Integer>(-1, null);
        Node<Integer> tail = null;
        while (head1!=null && head2!=null) {
            if(head1.getElement()<= head2.getElement()) {
                if(tail == null) {
                    dummy.setNext(head1);
                    tail = head1;
                } else {
                    tail.setNext(head1);
                    tail = head1;
                }
                head1 = head1.getNext();
            } else {
                if(tail == null) {
                    dummy.setNext(head2);
                    tail = head2;
                } else {
                    tail.setNext(head2);
                    tail = head2;
                }
                head2 = head2.getNext();
            }
        }

        if(head1 == null) {
            while (head2!=null) {
                if(tail == null) {
                    return head2;
                } else {
                    tail.setNext(head2);
                    tail = head2;
                    head2 = head2.getNext();
                }
            }
        } else {
            while (head1!=null) {
                if(tail == null) {
                    return head1;
                } else {
                    tail.setNext(head1);
                    tail = head1;
                    head1 = head1.getNext();
                }
            }
        }
        return dummy.getNext();
    }

    public static Node<Integer> mergeByRecursion(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> result = null;
        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        if(head1.getElement()<= head2.getElement()) {
            result = head1;
            result.setNext(mergeByRecursion(head1.getNext(), head2));
        } else {
            result =head2;
            result.setNext(mergeByRecursion(head1, head2.getNext()));
        }
        return result;
    }

    public static void  printList(Node<Integer> head) {
        Node<Integer> tmp = head;
        while (tmp!=null) {
            System.out.println(tmp.getElement());
            tmp = tmp.getNext();
        }
    }
}

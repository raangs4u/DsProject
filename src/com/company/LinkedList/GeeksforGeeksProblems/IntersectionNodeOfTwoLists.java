package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 24/6/15.
 */
public class IntersectionNodeOfTwoLists {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list1.addFirst(i);
        }

        Node<Integer> jointNode = new Node<Integer>(6,null);

        Node<Integer> head1  = list1.getHead();

        while (head1.getNext().getElement()!= 2) {
            head1 = head1.getNext();
        }

        jointNode.setNext(head1.getNext());
        head1.setNext(jointNode);
        //list1.printList();

        Node<Integer> head2 = new Node<Integer>(7, jointNode);

        head2 = new Node<Integer>(8,head2);
        head2 = new Node<Integer>(9,head2);
        head2 = new Node<Integer>(10,head2);
        head2 = new Node<Integer>(11,head2);

        System.out.println("Intersection Node element is: "+ findIntersectionNode(list1.getHead(), head2));

    }

    public static int findIntersectionNode(Node<Integer> head1, Node<Integer> head2) {
        int count1 = 0;
        int count2 = 0;

        Node<Integer> current1 = head1;
        Node<Integer> current2 = head2;

        while (current1!=null) {
            count1++;
            current1 = current1.getNext();
        }

        current1 = head1;

        while (current2!=null) {
            count2++;
            current2 = current2.getNext();
        }

        current2 = head2;

        if(count1 >= count2) {
            int diff = count1 - count2;
            while (diff > 0) {
                current1 = current1.getNext();
                diff--;
            }

            while (current1 != null && current2 != null) {
                if(current1.getElement() == current2.getElement()) {
                    return current1.getElement();
                }

                current1 = current1.getNext();
                current2 = current2.getNext();
            }

        } else {
            int diff = count2 - count1;
            while (diff > 0) {
                current2 = current2.getNext();
                diff--;
            }

            while (current1 != null && current2 != null) {
                if(current1.getElement() == current2.getElement()) {
                    return current1.getElement();
                }

                current1 = current1.getNext();
                current2 = current2.getNext();
            }
        }

        return -1;

    }
}

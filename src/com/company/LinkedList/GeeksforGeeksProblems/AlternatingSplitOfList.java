package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by rmandada on 30/6/15.
 */
public class AlternatingSplitOfList {

    public static void main(String[] args) {
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        for (int i = 7; i >0 ; i--) {
            list2.addFirst(i);
        }
        alternatingSplit(list2.getHead());
    }

    public static void alternatingSplit(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> aDummy = new Node<Integer>(-1, null);
        Node<Integer> bDummy = new Node<Integer>(-2, null);
        Node<Integer> aTail = null;
        Node<Integer> bTail = null;

        while (current!=null) {
            Node<Integer> node = new Node<Integer>(current.getElement(), null);
            if(aTail == null) {
                aDummy.setNext(node);
                aTail = node;
            } else {
                aTail.setNext(node);
                aTail = node;
            }
            current = current.getNext();
            if(current!=null) {
                Node<Integer> n = new Node<Integer>(current.getElement(), null);
                if(bTail == null) {
                    bDummy.setNext(n);
                    bTail = n;
                } else {
                    bTail.setNext(n);
                    bTail = n;
                }
                current = current.getNext();
            }

        }
        //printList(head);
        //printList(aDummy.getNext());
        printList(bDummy.getNext());
    }

    public static void  printList(Node<Integer> head) {
        Node<Integer> tmp = head;
        while (tmp!=null) {
            System.out.println(tmp.getElement());
            tmp = tmp.getNext();
        }
    }
}

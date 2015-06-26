package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/26/2015.
 */
public class PairWiseSwap {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        list.printList();
        //System.out.println("\n");
        Node<Integer> head = pairWiseSwap(list.getHead());
        list.setHead(head);
        list.printList();
    }

    public static Node<Integer> pairWiseSwap(Node<Integer> head) {
        Node<Integer> current = head;

        while (current!=null && current.getNext()!=null) {
            Node<Integer> tmp = current.getNext();
            if (current == head) {
                head = tmp;
            }
            current.getNext().setNext(current);
            current.setNext(tmp.getNext());
            current = current.getNext();
        }
        return head;
    }

    public static Node<Integer> pairWiseSwapByRecursion(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node<Integer> tmp = head.getNext();

        head.getNext().setNext(head);
        head.setNext(tmp.getNext());

        Node<Integer> head2 = pairWiseSwapByRecursion(head.getNext());
        return head.getNext();
    }
}

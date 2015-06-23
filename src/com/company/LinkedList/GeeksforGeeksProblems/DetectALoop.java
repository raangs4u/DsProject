package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/23/2015.
 */
public class DetectALoop {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        Node<Integer> cu = list.getHead();
        while (cu.getNext()!=null) {
            cu = cu.getNext();
        }
        cu.setNext(list.getHead());
        detectLoopByTwoPointers(list.getHead());
    }

    public static void detectLoopByTwoPointers(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (slow!=null && fast!=null && fast.getNext()!=null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                System.out.println("Found a loop");
                break;
            }
        }
    }
}

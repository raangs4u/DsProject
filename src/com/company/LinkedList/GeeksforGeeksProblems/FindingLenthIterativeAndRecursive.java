package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/13/2015.
 */
public class FindingLenthIterativeAndRecursive {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <5 ; i++) {
            list.addFirst(i);
        }

        System.out.println("Size By Iterative method: "+ getSizeByIterative(list.getHead()));
        System.out.println("Size By Recursive method: "+ getSizeByRecursive(list.getHead()));
    }

    public static int getSizeByIterative(Node<Integer> head ) {
        Node<Integer> node = head;
        int size = 0;
        while (node != null) {
            size+=1;
            node = node.getNext();
        }
        return size;
    }

    public static int getSizeByRecursive(Node<Integer> head) {
        if (head == null) {
            return 0;
        } else return 1+getSizeByIterative(head.getNext());
    }
}

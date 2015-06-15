package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/13/2015.
 */
public class SearchElementInLinkedListByIterativeAndRecursive {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <5 ; i++) {
            list.addFirst(i);
        }

        System.out.println("Search By Iterative method: "+ searchByIterative(list.getHead(), 3));
        System.out.println("Search By Recursive method: "+ searchByRecursive(list.getHead(), 0));
    }

    public static boolean searchByIterative(Node<Integer> head, int element) {
        Node<Integer> node = head;
        while (node != null) {
            if (node.getElement() == element) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public static boolean searchByRecursive(Node<Integer> head, int element) {
        if (head == null) {
            return false;
        }
        if (head.getElement() == element) {
            return true;
        } else {
            return searchByRecursive(head.getNext(), element);
        }
    }
}

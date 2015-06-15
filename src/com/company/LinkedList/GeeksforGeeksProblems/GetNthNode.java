package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/13/2015.
 */
public class GetNthNode {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <5 ; i++) {
            list.addFirst(i);
        }

        System.out.println("Element at index 0: "+ getNthNode(list.getHead(), 0).getElement());
        //System.out.println("Size By Recursive method: "+ getSizeByRecursive(list.getHead()));
    }

    public static Node getNthNode(Node<Integer> head, int n) {
        int i = 0;
        Node<Integer> node = head;
        while (node != null) {
            if(i == n) {
                return node;
            }
            i++;
            node = node.getNext();
        }
        return null;
    }
}

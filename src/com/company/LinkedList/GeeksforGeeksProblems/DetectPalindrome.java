package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/23/2015.
 */
public class DetectPalindrome {

    public static boolean isPalindrome(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Node<Integer> mid = null;
        Node<Integer> prevSlow = null;
        Node<Integer> secondHalf = null;

        while (slow!=null && fast!=null && fast.getNext()!=null) {
            prevSlow = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if(fast != null){
            mid = slow;
            secondHalf = mid.getNext();
        }

    }
}

package com.company.LinkedList.GeeksforGeeksProblems;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Node;

/**
 * Created by RANGA on 6/23/2015.
 */
public class DetectPalindrome {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        System.out.println("is palindrom: " + isPalindrome(list.getHead()));
    }

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
            slow = slow.getNext();
        }

        secondHalf = slow;

        secondHalf = ReverseLinkedList.reverseByIterative(secondHalf);
        prevSlow.setNext(null);

        boolean areEqual = compareTwoLists(head, secondHalf);

        secondHalf = ReverseLinkedList.reverseByIterative(secondHalf);
        if(mid != null) {
            prevSlow.setNext(mid);
            mid.setNext(secondHalf);
        } else {
            prevSlow.setNext(secondHalf);
        }

        return areEqual;

    }

    public static boolean compareTwoLists(Node<Integer> head1, Node<Integer> head2) {
        while (head1 != null && head2 != null) {
            if(head1.getElement() != head2.getElement()){
                return false;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        if(head1!=null || head2!=null) {
            return false;
        }
        return true;
    }
}

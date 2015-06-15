package com.company.Array;

import com.company.LinkedList.CircularLinkedList;
import com.company.LinkedList.Node;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*LinkedList list = new LinkedList();
        for (int i = 0; i <10 ; i++) {
            list.addFirst(new Node(i,null));
        }
        System.out.println(list.getSize());
        list.deleteFirst();
        Node node = list.getHead();
        while (node.getNext()!=null) {
            System.out.println(node.getElement());
            node = node.getNext();
        }*/
        //System.out.println(list.getSize());

        // DUCKS AND GOOSE

        CircularLinkedList C = new CircularLinkedList();
        int N =3;
        Node it;
        Node goose;

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());



    }
}

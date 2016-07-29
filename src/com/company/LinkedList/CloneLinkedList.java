package com.company.LinkedList;

import java.util.Map;

/**
 * @author rmandada
 */
public class CloneLinkedList {

    class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node cloneList(Node head, Map<Node, Node> map) {
        if(!map.containsKey(head)) {
            Node newNode = new Node(head.data);
            newNode.next = cloneList(head.next, map);
            newNode.random = cloneList(head.random, map);
            return newNode;
        } else {
            return map.get(head);
        }
    }
}

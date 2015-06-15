package com.company.LinkedList;

/**
 * Created by RANGA on 1/14/2015.
 */
public class LinkedList<E> {

    protected Node<E> head;

    //protected Node tail;

    protected long size;

    //protected List<Node> list = new ArrayList<Node>();

   /* public int getSize(){
        return list.size();
    }*/

    public long getSize() {
        return size;
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(E v){
        Node<E> n = new Node<E>(v,null);
        if(head==null){
            head = n;
            size+=1;
        } else {
            n.setNext(head);
            head = n;
            size+=1;
        }
    }
    public void addLast(E v) {
        Node<E> n = new Node<E>(v,null);
        if (head == null){
            head = n;
            size+=1;
        }else {
            Node<E> node = head;
            while (node.getNext()!=null){
                node = node.getNext();
            }
            node.setNext(n);
            size+=1;
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void deleteFirst(){
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }
        Node<E> t = head;
        head = head.getNext();
        t.setNext(null);
        size = size-1;
    }

    public void deleteNode(Node<E> node) {
        Node<E> current = head;
        while (current != null && current.getNext() != node) {
            current = current.getNext();
        }
        current.setNext(node.getNext());
        node = null;
        size = size -1;
    }

    public void deleteNodeWithOutHead(Node<E> node) {
        Node<E> tmp = node.getNext();
        node.setElement(tmp.getElement());
        node.setNext(tmp.getNext());
        tmp = null;
        size = size-1;
    }

    public void printList(Node<E> node) {
        Node<E> tmp = node;
        while (tmp!=null) {
            System.out.println(tmp.getElement());
            tmp = tmp.getNext();
        }
    }

}

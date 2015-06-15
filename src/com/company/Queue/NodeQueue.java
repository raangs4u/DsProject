package com.company.Queue;

import com.company.LinkedList.Node;

/**
 * Created by RANGA on 1/15/2015.
 */
public class NodeQueue<E> implements Queue<E> {

    public int size;

    public Node<E> head,tail;

    public NodeQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public E front() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException("Queue is Empty");
        return head.getElement();
    }

    @Override
    public void enqueue(E element) {
        Node<E> v = new Node<E>(element,null);
        tail.setNext(v);
        tail = v;
        size++;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException("Queue is Empty");
        E v = head.getElement();
        head = head.getNext();
        size--;
        if(size==0) {
            tail = null;
        }
        return v;
    }
}

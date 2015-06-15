package com.company.Stack;

import com.company.LinkedList.Node;

/**
 * Created by RANGA on 1/14/2015.
 */
public class NodeStack<E> implements Stack<E> {
    public Node<E> top;
    public int size;


    public NodeStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (top==null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is Empty");
        return top.getElement();
    }

    @Override
    public void push(E element) {
        Node<E> v = new Node<E>(element,null);
        v.setNext(top);
        top = v;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is Empty");
        E el  =top.getElement();
        top = top.getNext();
        size--;
        return el;
    }
}

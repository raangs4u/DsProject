package com.company.LinkedList;

/**
 * Created by RANGA on 1/14/2015.
 */
public class DNode {

    private int element;
    private DNode next;
    private DNode previous;

    public DNode(int element, DNode next, DNode previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public int getElement() {

        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrevious() {
        return previous;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }
}

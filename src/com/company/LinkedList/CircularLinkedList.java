package com.company.LinkedList;

/**
 * Created by RANGA on 1/14/2015.
 */
public class CircularLinkedList {

    protected Node cursor;
    protected long size;

    public CircularLinkedList() {
        cursor = null;
        size = 0;
    }

    public Node getCursor() {

        return cursor;
    }

    public void setCursor(Node cursor) {
        this.cursor = cursor;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void add(Node v) {
        if(size==0){
            cursor = v;
            cursor.setNext(v);
            //size++;
        } else {
            v.setNext(cursor.getNext());
            cursor.setNext(v);
            //size++;
        }
        size++;
    }

    public Node remove(){
        if(size==0) throw new IllegalArgumentException("List is Empty");
        if (cursor.getNext()!=cursor){
            Node w = cursor.getNext();
            cursor.setNext(w.getNext());
            w.setNext(null);
            size--;
            return w;
        } else {
            Node w = cursor;
            cursor = null;
            size--;
            return w;
        }
    }

    public void advance() {
        if(size==0) throw new IllegalArgumentException("List is Empty");
        cursor = cursor.getNext();
    }
}

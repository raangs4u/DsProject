package com.company.LinkedList;

/**
 * Created by RANGA on 1/14/2015.
 */
public class DLinkedList {

    private DNode header;
    private DNode trailer;
    private long size;

    public DLinkedList() {
        header.setNext(null);
        header.setPrevious(null);
        trailer.setNext(null);
        trailer.setPrevious(null);

        size = 0;

    }

    public DNode getHeader() {
        return header;
    }

    public void setHeader(DNode header) {
        this.header = header;
    }

    public DNode getTrailer() {
        return trailer;
    }

    public void setTrailer(DNode trailer) {
        this.trailer = trailer;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void addBefore(DNode v, DNode n) {
        DNode w = v.getPrevious();
        w.setNext(n);
        n.setPrevious(w);
        n.setNext(v);
        v.setPrevious(n);
        size+=1;
    }

    public void addAfter(DNode v, DNode n) {
        DNode w = v.getNext();
        v.setNext(n);
        n.setPrevious(v);
        n.setNext(w);
        w.setPrevious(n);
        size+=1;
    }
    public void addFirst(DNode n) {
        /*if(header.getNext()==null) {
            header.setNext(n);
            trailer.setPrevious(n);
            size+=1;
        } else {
            n.setNext(header.getNext());
            n.setPrevious(header);
            header.setNext(n);
            n.getNext().setPrevious(n);
            size+=1;
        }*/

        addAfter(header,n);
    }

    public void addLast(DNode n) {
        /*if(trailer.getPrevious()==null) {
            header.setNext(n);
            trailer.setPrevious(n);
            size+=1;
        }else {
            DNode w = trailer.getPrevious();
            w.setNext(n);
            n.setPrevious(w);
            n.setNext(trailer);
            trailer.setPrevious(n);
            size+=1;
        }*/

        addBefore(trailer,n);
    }

    public void removeFirst() {
        if (size == 0) throw new IllegalArgumentException("List is Empty");

        DNode f = header.getNext();
        header.setNext(f.getNext());
        f.getNext().setPrevious(header);
        f.setPrevious(null);
        f.setNext(null);
        size-=1;
    }

    public void removeAfter(DNode n) {

        DNode w = n.getNext();
        n.setNext(w.getNext());
        w.getNext().setPrevious(n);
        w.setNext(null);
        w.setPrevious(null);
        size-=1;
    }

    public void removeLast() {
        if (size == 0) throw new IllegalArgumentException("List is Empty");
        DNode l = trailer.getPrevious();
        l.getPrevious().setNext(trailer);
        trailer.setPrevious(l.getPrevious());
        l.setNext(null);
        l.setPrevious(null);
        size-=1;
    }

    public void remove(DNode n){
        DNode w = n.getNext();
        DNode p = n.getPrevious();

        p.setNext(w);
        w.setPrevious(p);

        n.setNext(null);
        n.setPrevious(null);
        size-=1;
    }

    public DNode getFirst(){
        return header.getNext();
    }

    public DNode getLast() {
        return trailer.getPrevious();
    }

}

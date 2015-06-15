package com.company.Queue;

/**
 * Created by RANGA on 1/15/2015.
 */
public class ArrayQueue<E> implements Queue<E> {

    public static final int CAPACITY = 1000;
    public int capacity;

    public int f,r;

    public E[] Q;
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        Q = (E[])new Object[capacity];
        f=0;
        r=0;
    }

    public ArrayQueue() {
        this(CAPACITY);
    }

    @Override
    public int size() {
        return (capacity-f+r)%capacity;
    }

    @Override
    public boolean isEmpty() {
        return (f==r);
    }

    @Override
    public E front() throws EmptyQueueException {
        if(isEmpty()==true) throw new EmptyQueueException("Queue is Empty");
        return Q[f];
    }

    @Override
    public void enqueue(E element) throws FullQueueException{
        if(size()==capacity) throw new FullQueueException("Queue is Full");
        Q[r] = element;
        r = (r+1)%capacity;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if(isEmpty()==true) throw new EmptyQueueException("Queue is Empty");
        E el = Q[f];
        Q[f] = null;
        f = (f+1)%capacity;
        return el;
    }
}

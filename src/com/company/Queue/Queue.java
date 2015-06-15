package com.company.Queue;

/**
 * Created by RANGA on 1/15/2015.
 */
public interface Queue<E> {

    public int size();

    public boolean isEmpty();

    public E front() throws EmptyQueueException;

    public void enqueue(E element);

    public E dequeue() throws EmptyQueueException;
}

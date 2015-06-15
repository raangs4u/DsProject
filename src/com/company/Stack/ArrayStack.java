package com.company.Stack;

/**
 * Created by RANGA on 1/14/2015.
 */
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;

    public int capacity;

    public E[] S;

    public int top =-1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int cap) {
        capacity = cap;
        S = (E[])new Object[capacity];
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        if (top<0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public E top() throws EmptyStackException {
        if(top<0) throw new EmptyStackException("Stack is Empty");

        return S[top];
    }

    @Override
    public void push(E element) throws FullStackException {
        if (size() == capacity) throw new FullStackException("Stack is Full");
        S[++top] = element;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(top<0) throw new EmptyStackException("Stack is Empty");
        E element;
        element = S[top];
        S[top] = null;
        top--;
        return element;
    }

}

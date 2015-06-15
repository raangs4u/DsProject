package com.company.Tree;

import java.util.Iterator;

/**
 * Created by RANGA on 3/29/2015.
 */
public class LinkedTree<E> implements Tree<E> {
    public int size;

    public Position<E> root;

    public LinkedTree() {
        size = 0;
        root = null;
    }

    public void addNode(Position<E> parent, E element) {
        Position<E> node = new Position<E>(element);
        if(parent == null){
            root = node;
        } else {
            node.setParent(parent);
            parent.getChildren().add(node);
        }
        size+=1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public E replace(Position<E> v, E e) throws InvalidPositionException {
        v.setElement(e);
        return e;
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryVoilationException {
        return v.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
        return v.getChildren();
    }

    @Override
    public boolean isInternal(Position<E> v) throws InvalidPositionException {
        return !v.getChildren().isEmpty();
    }

    @Override
    public boolean isExternal(Position<E> v) throws InvalidPositionException {
        return v.getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v) throws InvalidPositionException {
        return v.getParent()==null;
    }

    public static <E> int depth(Tree<E> T, Position<E> v) {
        if (T.isRoot(v)) return 0;
        return 1 + depth(T, T.parent(v));
    }

    public static <E> int height1(Tree<E> T) {
        int h = 0;

        for (Position<E> v: T.positions()) {
            if (T.isExternal(v)) {
                h = Math.max(h,depth(T,v));
            }
        }

        return h;
    }

}

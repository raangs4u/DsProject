package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 3/29/2015.
 */
public class Position<E> {

    private Position<E> parent;

    private E element;

    private List<Position<E>> children;

    public Position<E> getParent() {
        return parent;
    }

    public void setParent(Position<E> parent) {
        this.parent = parent;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public List<Position<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Position<E>> children) {
        this.children = children;
    }

    public Position(E element) {
        this.element = element;
        this.parent = null;
        this.children = new ArrayList<Position<E>>();

    }
}

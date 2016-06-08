package com.company.Graph;

/**
 * @author rmandada
 */
public class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Pair p) {
        return p.first == this.first && p.second == this.second;
    }
}

package com.company.HeapMap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author rmandada
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        cache.get(2);
        cache.set(3,2);
        cache.get(2);
        cache.get(3);

    }
    HashMap<Integer, Integer> map;
    Deque<Integer> q;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>();
        q = new ArrayDeque<Integer>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            q.remove(key);
            q.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size()== cap) {
                int k = q.getFirst();
                map.remove(k);
                q.remove(k);
                map.put(key,value);
                q.addLast(key);
            } else {
                map.put(key,value);
                q.addLast(key);
            }
        } else {
            map.put(key,value);
            q.remove(key);
            q.addLast(key);
        }
    }
}

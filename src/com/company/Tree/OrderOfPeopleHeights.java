package com.company.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rmandada
 */
public class OrderOfPeopleHeights {

    public static void main(String[] args) {
        List<Integer> h = Arrays.asList(new Integer[]{5, 3, 2, 6, 1, 4});
        List<Integer> i = Arrays.asList(new Integer[]{0, 1, 2, 0, 3, 2});
        order(h,i);
    }

    static class Person implements Comparable<Person>{
        int height;
        int infront;

        public Person(int height, int infront) {
            this.height = height;
            this.infront = infront;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.valueOf(this.height).compareTo(o.height);
        }
    }
    public static ArrayList<Integer> order(List<Integer> heights, List<Integer> infronts) {
        List<Person> persons =  new ArrayList<>();
        int n = heights.size();
        for (int i = 0; i <n ; i++) {
            Person p = new Person(heights.get(i), infronts.get(i));
            persons.add(p);
        }
        Collections.sort(persons);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            result.add(0);
        }
        for(Person p : persons) {
            int idx = p.infront+1;
            int i=-1;
            while (idx > 0) {
                if (result.get(++i) == 0) {
                    idx--;
                }
            }
            result.set(i, p.height);
        }

        return result;
    }
}

package com.company.Array;

import java.util.ArrayList;

/**
 * Created by RANGA on 2/7/2016.
 */
public class Intervals {

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 9));
        insert(intervals, new Interval(4,6));
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int m =-1;
        int n=-1;
        int k=-1;
        int p=-1;
        for(int i=0; i<intervals.size();i++){
            Interval in = intervals.get(i);
            if(in.start<=newInterval.start && in.end>= newInterval.start){
                m=i;
            }
            if(in.start<=newInterval.end && in.end>= newInterval.end){
                n=i;
            }
            if(in.end <= newInterval.end) {
                k=i;
            }
            if(in.start <= newInterval.start){
                p=i;
            }
        }
        if(m>=0 && n>=0){
            Interval newIn= new Interval(intervals.get(m).start,intervals.get(n).end);
            int l=0;
            while(l<n-m+1){
                intervals.remove(m);
                l++;
            }
            intervals.add(m, newIn);
        } else if(m>=0 && n<0){
            Interval newIn= new Interval(intervals.get(m).start, newInterval.end);
            int l=0;
            while(l<k-m+1){
                intervals.remove(m);
                l++;
            }
            intervals.add(m, newIn);
        } else if(m<0 && n>=0){
            Interval newIn= new Interval(newInterval.start, intervals.get(n).end);
            int l=0;
            while(l<n-p){
                intervals.remove(p+1);
                l++;
            }
            intervals.add(p+1, newIn);
        } else {
            Interval newIn= new Interval(newInterval.start, newInterval.end);
            int l=0;
            while(l<k-p){
                intervals.remove(p+1);
                l++;
            }
            intervals.add(p+1, newIn);
        }

        return intervals;

    }
}

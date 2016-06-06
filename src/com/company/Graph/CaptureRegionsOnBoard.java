package com.company.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author rmandada
 */
public class CaptureRegionsOnBoard {

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> in = new ArrayList<>();
        in.add(stringToList("XXXX"));
        in.add(stringToList("XOOX"));
        in.add(stringToList("XXOX"));
        in.add(stringToList("XOXX"));
        solve(in);
    }

    public static void solve(ArrayList<ArrayList<Character>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] visited = new int[m][n];
        for(int i=0;i<n;i++) {
            if(a.get(0).get(i)=='O') {
                bfs(a,new Pair(0,i),visited);
            }
        }

        for(int i=0;i<n;i++) {
            if(a.get(m-1).get(i)=='O') {
                bfs(a,new Pair(m-1,i),visited);
            }
        }

        for(int i=0;i<m;i++) {
            if(a.get(i).get(0)=='O') {
                bfs(a,new Pair(i,0),visited);
            }
        }

        for(int i=0;i<m;i++) {
            if(a.get(i).get(n-1)=='O') {
                bfs(a,new Pair(i,n-1),visited);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(a.get(i).get(j)=='O') {
                    a.get(i).set(j, 'X');
                } else if(a.get(i).get(j)=='B') {
                    a.get(i).set(j, 'O');
                }
            }
        }
    }

    public static void bfs(ArrayList<ArrayList<Character>> a, Pair p, int[][] visited) {
        visited[p.first][p.second] = 1;
        if(a.get(p.first).get(p.second)=='O') {
            a.get(p.first).set(p.second, 'B');
        }
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(p);
        int m = visited.length;
        int n = visited[0].length;

        while (!queue.isEmpty()) {
            p = queue.poll();
            if (p.first <m-1 && a.get(p.first+1).get(p.second) == 'O' && visited[p.first+1][p.second] == 0) {
                if(a.get(p.first).get(p.second) == 'B') {
                    a.get(p.first+1).set(p.second, 'B');
                }

                visited[p.first+1][p.second] = 1;
                queue.addLast(new Pair(p.first+1, p.second));
            }
            if (p.second <n-1 && a.get(p.first).get(p.second+1) == 'O' && visited[p.first][p.second+1]==0) {
                if(a.get(p.first).get(p.second) == 'B') {
                    a.get(p.first).set(p.second+1, 'B');
                }
                visited[p.first][p.second+1] = 1;
                queue.addLast(new Pair(p.first, p.second+1));
            }
            if (p.first >0 && a.get(p.first-1).get(p.second) == 'O' && visited[p.first-1][p.second] == 0) {
                if(a.get(p.first).get(p.second) == 'B') {
                    a.get(p.first-1).set(p.second, 'B');
                }
                visited[p.first-1][p.second] = 1;
                queue.addLast(new Pair(p.first-1, p.second));
            }
            if (p.second >0 && a.get(p.first).get(p.second-1) == 'O' && visited[p.first][p.second-1] == 0) {
                if(a.get(p.first).get(p.second) == 'B') {
                    a.get(p.first).set(p.second-1, 'B');
                }
                visited[p.first][p.second-1] = 1;
                queue.addLast(new Pair(p.first, p.second-1));
            }
        }
    }

    public static ArrayList<Character> stringToList(String s) {
        ArrayList<Character> r = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            r.add(c);
        }

        return r;
    }
}

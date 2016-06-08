package com.company.Graph;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rmandada
 */
public class SmallestMultipleWithOneAndZero {

    public static void main(String[] args) {
        System.out.println(multiple1(1000000007));
    }

    public static String multiple1(int A) {
        int[] flag = new int[A];
        int[] parent = new int[A];
        int[] val = new int[A];

        int p;
        int q;
        int i;
        int tot = 0;

        //final string
        StringBuilder ret = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        int temp = 1%A;
        flag[temp] = 1;
        val[temp] = 1;
        queue.addLast(temp);
        while (true) {
            temp = queue.removeFirst();
            p = temp;
            if (p==0) {
                p=0;
                ret.append(val[p]);
                p = parent[p];
                while (p!=0) {
                    ret.append(val[p]);
                    p = parent[p];
                }
                ret = ret.reverse();
                return ret.toString();
            }

            q = (p*10) %A;
            if (flag[q]==0) {
                queue.addLast(q);
                flag[q] = 1;
                parent[q] = p;
                val[q] = 0;
            }
            q++;
            if (q >= A) {
                q -= A;
            }
            if (flag[q]==0) {
                queue.addLast(q);
                flag[q] = 1;
                parent[q] = p;
                val[q] = 1;
            }

        }
    }
    public static String multiple(int A) {
        State[] s = new State[A];
        int[] visited = new int[A];
        for (int i = 0; i <A ; i++) {
            s[i] = new State(String.valueOf(i));
        }
        s[1].n = 1;
        State res = bfs1(s, s[1], A,visited);
        String ss = "";
        int p = Integer.parseInt(res.val);
        while (res != null && p != -1) {
            res = s[p];
            ss = res.n + ss;
            p = res.parent;
        }
        return ss;

    }

    public static State bfs1(State[] states, State curr, int A, int[] visited) {
        Deque<State> queue = new ArrayDeque<>();
        queue.add(curr);
        visited[Integer.parseInt(curr.val)] = 1;

        while (!queue.isEmpty()) {
            State s= queue.poll();
            int idx = Integer.parseInt(s.val);
            if (idx == 0) {
                return s;
            } else {
                int idx1 = Integer.parseInt(s.val+"0")%A;
                int idx2 = Integer.parseInt(s.val+"1")%A;
                if (visited[idx1]==0) {
                    states[idx1].parent = idx;
                    states[idx1].n = 0;
                    queue.add(states[idx1]);
                    visited[idx1] = 1;
                }

                if (visited[idx2]==0) {
                    states[idx2].parent = idx;
                    states[idx2].n = 1;
                    queue.add(states[idx2]);
                    visited[idx2] = 1;
                }
            }
        }

        return null;
    }

    public static String  bfs(int num, int A) {

        Deque<BigInteger> queue = new ArrayDeque<>();
        queue.add(BigInteger.valueOf(num));

        while (!queue.isEmpty()) {
            BigInteger n = queue.poll();
            if (n.remainder(BigInteger.valueOf(A)).equals(BigInteger.ZERO)) {
                return n.toString();
            }
            BigInteger b = n.multiply(BigInteger.valueOf(10));
            queue.add(b);
            b = b.add(BigInteger.ONE);
            queue.add(b);
        }

        return null;
    }

    static class State {
        int parent = -1;
        int n;
        String val;

        public State(String val) {
            this.val = val;
        }
    }
}

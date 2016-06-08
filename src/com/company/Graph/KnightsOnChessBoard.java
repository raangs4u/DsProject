package com.company.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rmandada
 */
public class KnightsOnChessBoard {

    public static void main(String[] args) {
        System.out.println(knight(2,20,1,18,1,5));
    }

    public static int knight(int N, int M, int x1, int y1, int x2, int y2) {
        x1--;
        y1--;
        x2--;
        y2--;
        Deque<Pair> queue = new ArrayDeque<>();
        int[][] dist = new int[N][M];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                dist[i][j] = -1;
            }
        }
        dist[x1][y1] = 0;
        Pair source = new Pair(x1,y1);
        Pair dest = new Pair(x2,y2);
        queue.addLast(source);
        Pair t=source;
        boolean found = false;
        while (!queue.isEmpty()) {
            t = queue.removeFirst();
            if (t.equals(dest)) {
                found = true;
                break;
            }
            if (t.first-2>=0 && t.second-1 >=0 && dist[t.first-2][t.second-1] == -1) {
                dist[t.first-2][t.second-1] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first-2,t.second-1));
            }
            if (t.first-1>=0 && t.second-2 >=0 && dist[t.first-1][t.second-2] == -1) {
                dist[t.first-1][t.second-2] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first-1,t.second-2));
            }
            if (t.first-2>=0 && t.second+1 <M && dist[t.first-2][t.second+1] == -1) {
                dist[t.first-2][t.second+1] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first-2,t.second+1));
            }
            if (t.first-1>=0 && t.second+2 <M && dist[t.first-1][t.second+2] == -1) {
                dist[t.first-1][t.second+2] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first-1,t.second+2));
            }
            if (t.first+1<N && t.second-2 >=0 && dist[t.first+1][t.second-2] == -1) {
                dist[t.first+1][t.second-2] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first+1,t.second-2));
            }
            if (t.first+2<N && t.second-1 >=0 && dist[t.first+2][t.second-1] == -1) {
                dist[t.first+2][t.second-1] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first+2,t.second-1));
            }
            if (t.first+1<N && t.second+2 <M && dist[t.first+1][t.second+2] == -1) {
                dist[t.first+1][t.second+2] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first+1,t.second+2));
            }
            if (t.first+2<N && t.second+1 <M && dist[t.first+2][t.second+1] == -1) {
                dist[t.first+2][t.second+1] = dist[t.first][t.second] +1;
                queue.addLast(new Pair(t.first+2,t.second+1));
            }

        }

        if (found) {
            return dist[t.first][t.second];
        }

        return -1;
    }
}

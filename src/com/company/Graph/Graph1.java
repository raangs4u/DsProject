package com.company.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 12/13/2015.
 */
public class Graph1 {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private List<List<Integer>> adjacencyList;

    private int V;

    private int E;

    public Graph1(int v) {
        V = v;
        E = 0;
        adjacencyList = new ArrayList<List<Integer>>(v);
        for (int i = 0; i <v ; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        List uList = adjacencyList.get(u);
        List vList = adjacencyList.get(v);
        uList.add(v);
        vList.add(u);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <adjacencyList.size() ; i++) {
            sb.append(i+1 +" : ");
            //System.out.print(i+" : ");
            for (int j = 0; j <adjacencyList.get(i).size() ; j++) {
                //System.out.print(j + " ");
                sb.append(adjacencyList.get(i).get(j)+1 + SPACE);
            }
            //System.out.println();
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }

}

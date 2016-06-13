package com.company.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rmandada
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return cloneGraphUtil(node, map);
    }

    public UndirectedGraphNode cloneGraphUtil(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (!map.containsKey(node)) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node,newNode);
            for (UndirectedGraphNode node1: node.neighbors) {
                newNode.neighbors.add(cloneGraphUtil(node1, map));
            }
            return newNode;
        } else {
            return map.get(node);
        }
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }
}

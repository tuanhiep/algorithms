package tuanhiep.usa.algo.search.graph;

import tuanhiep.usa.common.abstractAlgo;

import java.util.HashSet;

public class DepthFirstSearch extends abstractAlgo {
    public void setUpDefault() {
        Graph graph = new Graph();
        Node no1 = new Node(1);
        Node no2 = new Node(2);
        Node no3 = new Node(3);
        Node no4 = new Node(4);
        Node no5 = new Node(5);
        Node no6 = new Node(6);
        Node no7 = new Node(7);
        graph.nodeLookUp.put(no1.getId(), no1);
        graph.nodeLookUp.put(no2.getId(), no2);
        graph.nodeLookUp.put(no3.getId(), no3);
        graph.nodeLookUp.put(no4.getId(), no4);
        graph.nodeLookUp.put(no5.getId(), no5);
        graph.nodeLookUp.put(no6.getId(), no6);
        graph.nodeLookUp.put(no7.getId(), no7);
        graph.setEdge(1, 2);
        graph.setEdge(2, 3);
        graph.setEdge(3, 4);
        graph.setEdge(2, 5);
        graph.setEdge(5, 6);
        graph.setEdge(3, 7);
        graph.setInitNode(no1);
        // Graph is first parameter
        getParameters().add(graph);
        // Node to search is second parameter
        getParameters().add(no7);
    }

    public void run() {
        Graph graph = (Graph) getParameters().get(0);
        Node keyNode = (Node) getParameters().get(1);
        HashSet<Integer> visitedNodes = new HashSet<Integer>();
        boolean result = hasPathDFS(graph.getInitNode().getId(), keyNode.getId(), visitedNodes, graph);
        getParameters().add(result);
    }

    private boolean hasPathDFS(int beginningId, int destId, HashSet<Integer> visitedNodes, Graph graph) {
        Node beginningNode = graph.getNode(beginningId);
        if (beginningId == destId) return true;
        if (beginningNode == null || visitedNodes.contains(beginningNode) || beginningNode.getAdjacent().size() == 0)
            return false;
        // a node is called visited when we checked its Id with keyNodeId
        visitedNodes.add(beginningNode.getId());
        for (Node nextNode : beginningNode.getAdjacent()) {
            if( hasPathDFS(nextNode.getId(), destId, visitedNodes, graph)) return true;
        }
        return false;
    }

    public Object getResult() {
        return getParameters().get(2);
    }

    public void print() {

    }
}

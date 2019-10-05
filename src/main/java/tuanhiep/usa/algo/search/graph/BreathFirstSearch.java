package tuanhiep.usa.algo.search.graph;

import tuanhiep.usa.common.abstractAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class BreathFirstSearch extends abstractAlgo {


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
        boolean result = hasPathBFS(graph.getInitNode().getId(), keyNode.getId(), visitedNodes, graph);
        getParameters().add(result);

    }

    private boolean hasPathBFS(int beginningId, int destId, HashSet<Integer> visitedNodes, Graph graph) {
        LinkedList<Integer> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(beginningId);
        while (!nextToVisit.isEmpty()) {
            int nodeId = nextToVisit.remove();
            if (nodeId == destId) {
                return true;
            }
            if (visited.contains(nodeId)) {
                continue;
            }
            visited.add(nodeId);
            Node node = graph.nodeLookUp.get(nodeId);
            LinkedList<Node> adjacent = node.getAdjacent();
            for (Node n : adjacent) {
                if (!visited.contains(n.getId())) {
                    nextToVisit.add(n.getId());

                }
            }
        }
        return false;
    }

    public Object getResult() {

        return null;
    }

    public void print() {

    }
}

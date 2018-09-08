package tuanhiep.usa.algo.search.graph;

import java.util.HashMap;

public class Graph {
    HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

    public Node getNode(int id) {
        return nodeLookUp.get(id);
    }
    public void setEdge(int sourceId, int destinationId){
        Node sourceNode = getNode(sourceId);
        Node destinationNode= getNode(destinationId);
        sourceNode.getAdjacent().add(destinationNode);
    }
}

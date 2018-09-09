package tuanhiep.usa.algo.search.graph;

import java.util.HashMap;

public class Graph {
    HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();
    Node initNode;
    public Node getNode(int id) {
        return nodeLookUp.get(id);
    }
    public void setEdge(int sourceId, int destinationId){
        Node sourceNode = getNode(sourceId);
        Node destinationNode= getNode(destinationId);
        sourceNode.getAdjacent().add(destinationNode);
    }

    public Node getInitNode() {
        return initNode;
    }

    public void setInitNode(Node initNode) {
        this.initNode = initNode;
    }

    public HashMap<Integer, Node> getNodeLookUp() {
        return nodeLookUp;
    }

    public void setNodeLookUp(HashMap<Integer, Node> nodeLookUp) {
        this.nodeLookUp = nodeLookUp;
    }
}

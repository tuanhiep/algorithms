package tuanhiep.usa.algo.search.graph;

import tuanhiep.usa.common.abstractAlgo;

public class DepthFirstSearch extends abstractAlgo {
    public void setUpDefault() {
        // Graph is first parameter
        getParameters().add(new Graph());
        // Node to search is second parameter
        getParameters().add(new Node(1));
    }

    public void run() {
        Graph graph = (Graph) getParameters().get(0);
        Node keyNode = (Node) getParameters().get(1);
        boolean result= hasChild(graph.getInitNode(),keyNode);
        getParameters().set(2,result);
    }

    private boolean hasChild(Node beginningNode, Node keyNode) {
        for (Node node: beginningNode.getAdjacent()) {
            if(node.getId()== keyNode.getId()) {
                return true;
            }
            if(hasChild(node,keyNode)) return true;

        }
        return false;
    }

    public Object getResult() {
        return getParameters().get(2);
    }
}

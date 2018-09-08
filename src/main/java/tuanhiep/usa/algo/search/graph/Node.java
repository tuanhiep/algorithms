package tuanhiep.usa.algo.search.graph;

import java.util.LinkedList;

public class Node {
    private int id;
    LinkedList<Node> adjacent= new LinkedList<Node>();
    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Node> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(LinkedList<Node> adjacent) {
        this.adjacent = adjacent;
    }
}

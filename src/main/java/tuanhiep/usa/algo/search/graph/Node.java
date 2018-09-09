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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getId() == node.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}

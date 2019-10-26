package tuanhiep.usa.algo.search.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class ShortestReach {
    private static int DISTANCE_EDGE = 6;

    public static void main(String[] args) {

    }

    /**
     * Algorithm to find the shortest path using BFS and with the hypothesis that all the edges have equal size
     *
     * @param startId
     * @param graph
     * @return
     */
    public HashMap<Node, Integer> shortestReach(int startId, Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startId);
        HashMap<Node, Integer> distances = new HashMap<>();
        Node startNode = graph.getNodeLookUp().get(startId);
        distances.put(startNode, 0);
        while (!queue.isEmpty()) {
            int nodeId = queue.poll();
            Node node = graph.getNodeLookUp().get(nodeId);
            for (Node neighbor : node.getAdjacent()) {
                if (!distances.containsKey(neighbor)) {
                    // Remark that in this problem we suppose that all the distance edge are of equal size
                    // so we update only if the distance of neighbor is not calculated because if even the cycle exists
                    // there are not problem of shorter path like in Dijkstra problem
                    distances.put(neighbor, distances.get(node) + DISTANCE_EDGE);
                    queue.add(neighbor.getId());
                }
            }
        }
        return distances;


    }


}

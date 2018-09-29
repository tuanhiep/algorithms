package tuanhiep.usa.algo.search.graph;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

public class DepthFirstSearchTest {
    private final DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
    @Test
    public void runTest() {
        // test case default
        depthFirstSearch.test(new ArrayList());
        boolean result = (Boolean) depthFirstSearch.getResult();
        Assertions.assertThat(result).isTrue();
        // test cycle
        Graph graph = new Graph();
        Node no1= new Node(1);
        Node no2= new Node(2);
        Node no3= new Node(3);
        Node no4= new Node(4);
        Node no5= new Node(5);
        Node no6= new Node(6);
        Node no7= new Node(7);
        graph.nodeLookUp.put(no1.getId(),no1);
        graph.nodeLookUp.put(no2.getId(),no2);
        graph.nodeLookUp.put(no3.getId(),no3);
        graph.nodeLookUp.put(no4.getId(),no4);
        graph.nodeLookUp.put(no5.getId(),no5);
        graph.nodeLookUp.put(no6.getId(),no6);
        graph.nodeLookUp.put(no7.getId(),no7);
        graph.setEdge(1,2);
        graph.setEdge(2,3);
        graph.setEdge(3,4);
        graph.setEdge(2,5);
        graph.setEdge(5,6);
        graph.setEdge(3,7);
        // make cycle by this edge
        graph.setEdge(4,5);
        graph.setInitNode(no1);
        ArrayList parameters = new ArrayList();
        parameters.add(graph);
        parameters.add(no7);

        depthFirstSearch.test(parameters);
        result= (Boolean) depthFirstSearch.getResult();
        Assertions.assertThat(result).isTrue();

    }
}
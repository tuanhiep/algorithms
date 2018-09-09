package tuanhiep.usa.algo.search.graph;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

public class DepthFirstSearchTest {
    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
    @Test
    public void runTest() {
        depthFirstSearch.test(new ArrayList());
        boolean result = (Boolean) depthFirstSearch.getResult();
        Assertions.assertThat(result).isFalse();
    }
}
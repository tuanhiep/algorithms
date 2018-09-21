package tuanhiep.usa.algo.sort;

import org.junit.Test;

import java.util.ArrayList;

public class BubbleSortTest {
    BubbleSort bubbleSort= new BubbleSort();
    @Test
    public void bubbleSortDefaultTest() {
        bubbleSort.setUpDefault();
        bubbleSort.test(new ArrayList());
        bubbleSort.print();
    }
}

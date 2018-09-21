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
    @Test
    public void bubbleSortTest() {
        bubbleSort.setUpDefault();
        ArrayList parameters= new ArrayList();
        int[] input = new int[]{9,1,7,3,8,1,78,33,54,11,13,15,63,95,4235,315663,3515,15,535131,1,1113513};
        parameters.add(input);
        bubbleSort.test(parameters);
        bubbleSort.print();
    }
}

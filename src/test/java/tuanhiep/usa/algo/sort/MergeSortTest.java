package tuanhiep.usa.algo.sort;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

    @Test
    public void mergeArrayTest() {
        int[] firstArray = new int[]{1, 3, 5, 8, 10};
        int[] secondArray = new int[]{2, 4, 6, 7, 9};
        int[] result = mergeSort.mergeArray(firstArray, secondArray);
        Assertions.assertThat(result).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

    }

    @Test
    public void mergeArrayOneOneTest() {
        int[] firstArray = new int[]{1};
        int[] secondArray = new int[]{2};
        int[] result = mergeSort.mergeArray(firstArray, secondArray);
        Assertions.assertThat(result).isEqualTo(new int[]{1, 2});
    }

    @Test
    public void mergeArrayTwoOneTest() {
        int[] firstArray = new int[]{1};
        int[] secondArray = new int[]{3, 5};
        int[] result = mergeSort.mergeArray(firstArray, secondArray);
        Assertions.assertThat(result).isEqualTo(new int[]{1, 3, 5});
    }

    @Test
    public void mergeSortDefaultTest() {
        mergeSort.setUpDefault();
        mergeSort.test(new ArrayList());
        mergeSort.print();
    }

    @Test
    public void mergeSortTest() {
        mergeSort.setUpDefault();
        int[] target = new int[]{3, 2, 1, 4};
        ArrayList parameters = new ArrayList();
        parameters.add(target);
        mergeSort.test(parameters);
        mergeSort.print();
    }

    @Test
    public void arrayCopyTest() {
        mergeSort.setUpDefault();

        int[] target = (int[]) mergeSort.getParameters().get(0);
        int size = target.length;
        // finished condition
        int middle = size / 2;
        int[] firstInput = new int[middle];
        System.arraycopy(target, 0, firstInput, 0, middle);
        Assertions.assertThat(firstInput).isEqualTo(new int[]{1, 3, 5, 6, 9, 2});

        int[] secondInput = new int[size - middle];
        System.arraycopy(target, middle, secondInput, 0, size - middle);
        Assertions.assertThat(secondInput).isEqualTo(new int[]{4, 10, 15, 14, 12, 11, 13});

    }
}
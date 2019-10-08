package tuanhiep.usa.algo.sort;

import tuanhiep.usa.common.*;

/**
 * Algorithm to do the quick sorting for an array
 */
public class QuickSort extends abstractAlgo {
    public void setUpDefault() {


    }

    public void run() {

    }

    public Object getResult() {
        return null;
    }

    public void print() {

    }

    public int[] quickSort(int[] array) throws Exception {

        return quickSort(array, 0, array.length - 1);


    }

    public static void main(String[] args) throws Exception {
        int[] array = {4, 5, 2, 9, 5, 3, 9, 38, 4, 22, 3};
        QuickSort quickSort = new QuickSort();
        int[] result = quickSort.quickSort(array);

//        int indexPivot = quickSort.partition(array, 3, array.length-1);
//        System.out.println(indexPivot);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

    }

    /**
     * Do quicksort for array elements in range: [start,end]
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int[] quickSort(int[] array, int start, int end) throws Exception {
        if (start == end) {
            return array;
        }
        if (start > end) {
            throw new Exception("Quick Sort error");
        }
        int pivotIndex = partition(array, start, end);
        if (pivotIndex > start) quickSort(array, start, pivotIndex - 1);
        if (pivotIndex + 1 < end) quickSort(array, pivotIndex + 1, end);
        return array;


    }

    /**
     * return the index of pivot when do partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) throws Exception {
        if (start > end) {
            throw new Exception("partition error");
        }
        if (start == end) {
            return end;
        }
        int pivot = array[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                index++;
            }

        }
        int temp = array[index];
        array[index] = array[end];
        array[end] = temp;
        return index;

    }


}

package tuanhiep.usa.algo.sort;

/**
 * Algorithm to do the quick sorting for an array
 */
public class QuickSort {


    public static void main(String[] args) throws Exception {
        int[] array = {4, 5, 2, 9, 5, 3, 9, 38, 4, 22, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

    }

    public void quickSort(int[] array) throws Exception {

        quickSort(array, 0, array.length - 1);


    }

    /**
     * Do quicksort for array elements in range: [start,end]
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private void quickSort(int[] array, int start, int end) throws Exception {

        if (start >= end) {
            return;
        }
        int pivotIndex = partitionWhile(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
        return;


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

    private int partitionWhile(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low, j = high;
        while (i < j) {

            while (i < high && array[i] <= pivot) {
                i++;
            }
            while (j > low && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;
        return j;

    }


}

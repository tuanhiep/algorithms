package tuanhiep.usa.algo.sort;

import tuanhiep.usa.common.abstractAlgo;
import tuanhiep.usa.common.utils.TypeAlgo;

import java.util.ArrayList;

/**
 * Algorithm to do the merge sorting for an array
 */
public class MergeSort extends abstractAlgo {
    public void setUpDefault() {
        ArrayList parametersDefault = new ArrayList();
        int[] targetArray = new int[]{1, 3, 5, 6, 9, 2, 4, 10, 15, 14, 12, 11, 13};
        parametersDefault.add(targetArray);
        this.setParameters(parametersDefault);
        this.setName("Merge Sort");
        this.setType(TypeAlgo.SORT);
        this.setDescription("This classical merge sorting method is used to sort an array in ascending order");
    }

    public void run() {
        int[] target = (int[]) this.getParameters().get(0);
        int[] output = mergeSort(target);
        this.getParameters().add(output);


    }

    public int[] mergeSort(int[] target) {
        int size = target.length;
        // finished condition
        if (size == 1) return target;
        int middle = size / 2;
        // first part of array to be sorted
        int[] firstInput = new int[middle];
        System.arraycopy(target, 0, firstInput, 0, middle);
        int[] firstPart = mergeSort(firstInput);
        // the rest of array to be sorted
        int[] secondInput = new int[size - middle];
        System.arraycopy(target, middle, secondInput, 0, size - middle);
        int[] secondPart = mergeSort(secondInput);
        // merge two parts to get the result
        return mergeArray(firstPart, secondPart);

    }

    protected int[] mergeArray(int[] firstPart, int[] secondPart) {
        int[] result = new int[firstPart.length + secondPart.length];
        int i = 0;
        int j = 0;
        int z = 0;
        while (i < firstPart.length || j < secondPart.length) {
            if (i == firstPart.length && j < secondPart.length) {
                result[z] = secondPart[j];
                z++;
                j++;
                continue;
            }
            if (j == secondPart.length && i < firstPart.length) {
                result[z] = firstPart[i];
                z++;
                i++;
                continue;
            }
            if (firstPart[i] < secondPart[j]) {
                result[z] = firstPart[i];
                z++;
                i++;
            } else {
                result[z] = secondPart[j];
                z++;
                j++;
            }

        }

        return result;
    }

    public Object getResult() {
        return this.getParameters().get(1);
    }

    public void print() {
        int[] input = (int[]) this.getParameters().get(0);
        int[] output = (int[]) this.getResult();
        System.out.println("\nInput Array");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println("\nOutput Array");

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}


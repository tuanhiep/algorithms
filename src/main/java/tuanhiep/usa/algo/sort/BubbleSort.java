package tuanhiep.usa.algo.sort;

import tuanhiep.usa.common.abstractAlgo;
import tuanhiep.usa.common.utils.TypeAlgo;

import java.util.ArrayList;

/**
 * Algorithm to do the bubble sorting for an array
 */
public class BubbleSort extends abstractAlgo {
    public void setUpDefault() {
        ArrayList parametersDefault = new ArrayList();
        int[] targetArray = {1, 3, 5, 6, 454, 51, 3, 13, 461, 313, 5, 31555, 151, 311489, 9, 77};
        parametersDefault.add(targetArray);
        this.setParameters(parametersDefault);
        this.setName("Bubble Sort");
        this.setType(TypeAlgo.SORT);
        this.setDescription("We use classical bubble sorting method to sort an array after ascending order ");
    }

    public void run() {
        int[] input = (int[]) this.getParameters().get(0);
        int[] target = input.clone();
        if (target.length <= 0) return;
        // sort the target array in the ascending order
        for (int j = 1; j < target.length; j++) {
            for (int i = 0; i < target.length - j; i++) {
                int temp;
                if (target[i] > target[i + 1]) {
                    temp = target[i + 1];
                    target[i + 1] = target[i];
                    target[i] = temp;
                }
            }

        }
        this.getParameters().add(target);

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

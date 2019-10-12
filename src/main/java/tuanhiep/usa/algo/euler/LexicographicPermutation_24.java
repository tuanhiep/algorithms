package tuanhiep.usa.algo.euler;

import java.util.LinkedList;

public class LexicographicPermutation_24 {
    public static void main(String[] args) {
        LinkedList<Integer> queue= initializeQueue(2);
        System.out.println(findPermutation(1,queue));
        System.out.println(findPermutation(2,queue));
        queue= initializeQueue(9);
        System.out.println(findPermutation(1000000,queue));
    }

    private static LinkedList<Integer> initializeQueue(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            queue.add(i);
        }
        return queue;
    }

    private static String findPermutation(int n, LinkedList<Integer> inputQueue) {
        LinkedList<Integer> queue = (LinkedList<Integer>) inputQueue.clone();
        int size = queue.size();
        int globalPosition = n;
        String result = "";
        for (int i = 0; i < size; i++) {
            int base = factorial(queue.size() - 1);
            int index=0;
            if (globalPosition > base) {
                globalPosition = globalPosition % base;
                index = globalPosition - 1;
            } else {
                globalPosition = globalPosition % base;

            }
            String nextElement = String.valueOf(queue.remove(index ));
            result += nextElement;

        }
        return result;

    }

    private static int factorial(int n) {
        if (n==0) {
            return 1;
        }
        int factorial=1;
        for (int i = 1; i <= n; i++) {
            factorial*=i;
        }
        return factorial;
    }
}

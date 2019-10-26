package tuanhiep.usa.algo.euler;

import java.util.LinkedList;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem24_LexicographicPermutation {
    public static void main(String[] args) {
        LinkedList<Integer> queue = initializeQueue(2);
        System.out.println(findPermutation(1, queue));
        System.out.println(findPermutation(2, queue));
        System.out.println(findPermutation(3, queue));
        queue = initializeQueue(9);
        System.out.println(findPermutation(1000000, queue));
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
            int chunk = 0;
            if (queue.size() > 1) {
                int base = factorial(queue.size() - 1);
                int divisor = globalPosition / base;
                int modulo = globalPosition % base;
                int position = 0;
                if (modulo == 0) {
                    chunk = divisor - 1;
                    position = base;
                } else {
                    chunk = divisor;
                    position = modulo;
                }
                globalPosition = position;
            }
            String nextElement = String.valueOf(queue.remove(chunk));
            result += nextElement;

        }
        return result;

    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

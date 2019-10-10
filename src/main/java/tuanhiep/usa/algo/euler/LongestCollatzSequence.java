package tuanhiep.usa.algo.euler;

import java.util.HashMap;

public class LongestCollatzSequence {
    public static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        memo.put(1, 1);
        System.out.println(getNumberOfChainIteratively(1));
        System.out.println(getNumberOfChainIteratively(2));
        System.out.println(getNumberOfChainIteratively(4));
        System.out.println(getNumberOfChainIteratively(8));
        System.out.println(getNumberOfChainIteratively(16));
        System.out.println(getNumberOfChainIteratively(5));
        System.out.println(getNumberOfChainIteratively(10));
        System.out.println(getNumberOfChainIteratively(20));
        System.out.println(getNumberOfChainIteratively(40));
        System.out.println(getNumberOfChainIteratively(13));
        System.out.println(findNumber(1000000));

    }

    /**
     * Iterative approach give long waiting time
     *
     * @param i
     * @return
     */
    private static int getNumberOfChainIteratively(int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int element = i;
        int count = 0;
        while (element > 0) {
            if (memo.containsKey(element)) {
                count = count + memo.get(element);
                break;
            }
            if (element % 2 == 0) {
                element = element / 2;
            } else {
                element = 3 * element + 1;
            }
            count++;
        }
        memo.put(i, count);
        return count;

    }

    public static int findNumber(int limit) {
        int max = 1;
        int number = 1;
        for (int i = 1; i < limit; i++) {
            int count = 0;
            if (memo.containsKey(i)) {
                count = memo.get(i);

            } else {
                count = getNumberOfChainIteratively(i);
            }

            if (count > max) {
                number = i;
                max = count;
            }
        }
        return number;
    }


}

package tuanhiep.usa.algo.euler;

import java.util.HashMap;

public class LongestCollatzSequence {
    public static void main(String[] args) {
        System.out.println(getNumberOfChain(8,new int[8]));
        System.out.println(getNumberOfChain(5, new int[5]));
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
        int count = 1;
        while (element != 1) {
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
        int[] result = new int[2];
        int max = 1;
        for (int i = 1; i < limit; i++) {
            int count = getNumberOfChainIteratively(i);
            if (count > max) {
                result[0] = i;
                result[1] = count;
                max = count;
            }
        }
        return result[0];
    }

    /**
     * Recursively but try to reduce n as soon as possible
     * @param n
     * @param memo
     * @return
     */
    private static int getNumberOfChain(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n<memo.length && memo[n]!=0) {
            return memo[n];
        }
        int num=0;
        if (n % 2 == 0) {
            num= 1 + getNumberOfChain(n / 2,memo);
        }
        else
        if ((n - 1) % 3 == 0) {
            num= getNumberOfChain((n - 1) % 3,memo) - 1;
        }
        else
        if (n % 2 != 0) {
            num= 1 + getNumberOfChain(3 * n + 1,memo);
        }
        if (n<memo.length) {
            memo[n] = num;
        }
        return num;
    }

    public static HashMap<Integer, Integer> memo = new HashMap<>();

    /**
     * Recursive approach give stackoverflow
     *
     * @param n
     * @return
     */
    public static int getNumberOfChainRecursively(int n) {

        if (n == 1) {

            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int num = 0;
        if (n % 2 == 0) {
            num = 1 + getNumberOfChainRecursively(n / 2);

        } else {
            num = 1 + getNumberOfChainRecursively(3 * n + 1);
        }
        memo.put(n, num);

        return num;

    }


}

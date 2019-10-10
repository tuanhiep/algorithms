package tuanhiep.usa.algo.euler;

import java.util.HashMap;

public class LongestCollatzSequence {
    public static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        memo.put(1L, 1L);
        System.out.println(getNumberOfChainMemorization(1));
        System.out.println(getNumberOfChainMemorization(2));
        System.out.println(getNumberOfChainMemorization(4));
        System.out.println(getNumberOfChainMemorization(8));
        System.out.println(getNumberOfChainMemorization(16));
        System.out.println(getNumberOfChainMemorization(5));
        System.out.println(getNumberOfChainMemorization(10));
        System.out.println(getNumberOfChainMemorization(20));
        System.out.println(getNumberOfChainMemorization(40));
        System.out.println(getNumberOfChainMemorization(13));
        System.out.println(getNumberOfChainMemorization(910107));
        System.out.println(getNumberOfChainMemorization(837799));
        System.out.println(findNumber(1000000));

    }

    /**
     * Iterative approach with memorization
     *
     * @param i
     * @return
     */
    private static long getNumberOfChainMemorization(long i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        long term = i;
        long count = 0;
        while (term >=1) {

            if (term % 2 == 0) {
                term = term / 2;
            } else {
                term = 3 * term + 1;
            }
            count++;
            if (memo.containsKey(term)) {
                count = count + memo.get(term);
                break;
            }
        }
        memo.put(i, count);
        return count;

    }

    public static long findNumber(long limit) {
        long max = 1;
        long number = 1;
        for (long i = 1; i < limit; i++) {
            long count = 0;
            count = getNumberOfChainMemorization(i);
            if (count > max) {
                number = i;
                max = count;
            }
        }
        return number;
    }


}

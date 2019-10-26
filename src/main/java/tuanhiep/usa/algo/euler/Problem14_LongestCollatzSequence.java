package tuanhiep.usa.algo.euler;

import java.util.HashMap;

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem14_LongestCollatzSequence {
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

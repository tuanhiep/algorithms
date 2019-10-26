package tuanhiep.usa.algo.euler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21_AmicableNumber {
    public static void main(String[] args) {
        System.out.println(findSum(10000));
        System.out.println(getSumDivisor(220));
        System.out.println(getSumDivisor(284));
    }

    private static long findSum(int n) {
        long sum = 0;
        HashMap<Integer, Integer> amicables = getAmicableNumber(n);
        for (int key : amicables.keySet()) {
            sum += key;
        }
        return sum;
    }

    private static HashMap<Integer, Integer> getAmicableNumber(int n) {

        HashMap<Integer, Integer> amicables = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (!amicables.containsKey(i)) {
                int sumI = getSumDivisor(i);
                int sumSumI = getSumDivisor(sumI);
                if (sumSumI == i && i != sumI) {
                    amicables.put(i, sumI);
                    amicables.put(sumI, i);
                }
            }
        }
        return amicables;


    }

    private static int getSumDivisor(int number) {
        HashSet<Integer> divisors = getDivisor(number);
        Iterator value = divisors.iterator();
        int sum = 0;
        while (value.hasNext()) {
            sum += (int) value.next();
        }
        return sum;

    }

    private static HashSet<Integer> getDivisor(int number) {
        HashSet<Integer> divisors = new HashSet<>();
        for (int i = 1; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i && i != 1) {
                    divisors.add(number / i);
                }
            }
        }
        return divisors;

    }

}

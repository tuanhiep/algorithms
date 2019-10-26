package tuanhiep.usa.algo.euler;

import java.util.HashSet;
import java.util.Iterator;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Problem23_NonAbundantSum {
    public static void main(String[] args) {

        System.out.println(getDivisor(2));
        System.out.println(getDivisor(12));
        System.out.println(getDivisor(28));
        System.out.println(isAbundant(12));
        System.out.println(getAbundant());
        System.out.println(sumNonAbundant());
    }

    private static long sumNonAbundant() {
        return 28123 * (28123 + 1) / 2 - getSumNumberTwoAbundants();
    }

    private static long getSumNumberTwoAbundants() {
        long sum = 0;
        HashSet<Integer> abundants = getAbundant();

        for (int i = 1; i <= 28123; i++) {
            if (isSumTwoAbundant(i,abundants)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isSumTwoAbundant(int number, HashSet<Integer> abundants) {
        HashSet<Integer> complements = new HashSet<>();
        for (int a:abundants) {
            int c = number - a;
            complements.add(c);
        }
        complements.retainAll(abundants);
        return !complements.isEmpty();
    }

    private static HashSet<Integer> getAbundant() {
        HashSet<Integer> abundants = new HashSet<>();
        for (int i = 12; i <= 28123; i++) {
            if (!abundants.contains(i) && isAbundant(i)) {
                abundants.add(i);
            }
        }
        return abundants;
    }

    private static boolean isAbundant(int number) {
        return getSumDivisor(number) > number;

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
            if (number % i == 0 && i != number) {
                divisors.add(i);
                if (i != number / i && i != 1) {
                    divisors.add(number / i);
                }
            }
        }
        return divisors;

    }
}

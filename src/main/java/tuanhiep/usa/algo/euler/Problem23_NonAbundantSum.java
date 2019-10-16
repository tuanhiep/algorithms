package tuanhiep.usa.algo.euler;

import java.util.HashSet;
import java.util.Iterator;

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

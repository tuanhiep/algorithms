package tuanhiep.usa.algo.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem33_DigitCancellingFractions {
    public static void main(String[] args) {
        System.out.println(isCurious(49, 98));
        System.out.println(isCurious(30, 50));
        System.out.println(findDenominatorProduct());

    }

    private static int findDenominatorProduct() {
        ArrayList<Fraction> curious = findCuriousFraction();
        int numeratorProduct = 1;
        int denominatorProduct = 1;
        for (Fraction f : curious) {
            numeratorProduct *= f.getNumerator();
            denominatorProduct *= f.getDenominator();
        }

        int greatestCommonDivisor = (int) findGreatestCommonDivisor(numeratorProduct, denominatorProduct);
        return denominatorProduct / greatestCommonDivisor;


    }

    private static ArrayList<Fraction> findCuriousFraction() {
        ArrayList<Fraction> list = new ArrayList<>();
        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                if (isCurious(numerator, denominator)) {
                    list.add(new Fraction(numerator, denominator));
                }
            }
        }
        return list;


    }

    private static boolean isCurious(int numerator, int denominator) {
        if (numerator > denominator) {
            return false;
        }
        List<Integer> nu = new ArrayList<>();
        nu.add(numerator / 10);
        nu.add(numerator % 10);
        List<Integer> de = new ArrayList<>();
        de.add(denominator / 10);
        de.add(denominator % 10);

        List<Integer> common = findCommonLists(nu, de);
        if (common.size() == 0) {
            return false;
        }
        if (common.size() == 1 && common.get(0) == 0) {
            return false;
        }

        nu.removeAll(common);
        de.removeAll(common);
        int innocentNum;
        int innocentDen;
        if (nu.size() == 0) {
            innocentNum = common.get(0);
        } else {
            innocentNum = nu.get(0);
        }
        if (de.size() == 0) {
            innocentDen = common.get(0);
        } else {
            innocentDen = de.get(0);
        }
        if (innocentDen == 0) {
            return false;
        }

        return (double)numerator / denominator == (double) innocentNum / innocentDen;

    }

    /**
     * Find common elements beetween two lists
     * @param list1
     * @param list2
     * @return
     */
    private static List<Integer> findCommonLists(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<Integer>(list2);
        list3.retainAll(list1);
        return list3;

    }

    private static long findGreatestCommonDivisor(long a, long b) {
        if (a % b != 0)
            return findGreatestCommonDivisor(b, a % b);
        else
            return b;

    }

}

class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}

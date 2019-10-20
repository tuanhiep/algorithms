package tuanhiep.usa.algo.euler;

import java.util.HashMap;
import java.util.HashSet;

public class Problem38_PandigitalMultiples {
    public static HashSet<Integer> memo = new HashSet<>();
    public static HashSet<Integer> digits = new HashSet<>();


    public static void main(String[] args) {
        initDigit();
        System.out.println(concatenate(192, 3));
        System.out.println(isPandigital(concatenate(192, 3)));
        System.out.println(findLargestPandigital());
    }

    private static void initDigit() {
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
    }

    private static long findLargestPandigital() {
        long max = 1;
        for (int i = 1; i < 999999999; i++) {
            long largest = findLargest(i);
            if (largest > max) {
                max = largest;
            }
        }
        return max;

    }

    private static long findLargest(int number) {

        long max = -1;
        int n = 1;
        int product = 1;
        while (product < 999999999) {
            product = concatenate(number, n);
            if (product != -1 && isPandigital(product) && product > max && product < 999999999) {
                max = product;
            }
        }
        return max;


    }

    private static boolean isPandigital(int product) {
        if (memo.contains(product)) {
            return true;
        }
        String toCheck = String.valueOf(product);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < toCheck.length(); i++) {
            set.add(Character.getNumericValue(toCheck.charAt(i)));
        }
        if (set.size() != 9) {
            return false;
        }
        memo.add((int) product);
        return true;


    }

    private static int concatenate(int number, int n) {
        if (n == 1) {
            if (isPandigital(number)) {
                return number;
            }
            return -1;
        }

        String result = "";
        HashSet<Integer> comparingSet = (HashSet<Integer>) digits.clone();
        for (int i = 1; i <= n; i++) {
            int product = number * i;
            if (!validDigit(comparingSet,product)) {
                return -1;
            }
            result += String.valueOf(product);
        }
        return Integer.parseInt(result);

    }

    private static boolean validDigit(HashSet<Integer> comparingSet, int product) {
        String pro = String.valueOf(product);
        int size = pro.length();
        int initialSizeSet = comparingSet.size();
        for (int i = 0; i < size; i++) {
            comparingSet.remove(Character.getNumericValue(pro.charAt(i)));
        }
        if (initialSizeSet -comparingSet.size()!= size) {
            return false;
        }
        return true;



    }




}

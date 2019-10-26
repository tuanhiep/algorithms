package tuanhiep.usa.algo.euler;

import java.util.ArrayList;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem41_PandigitalPrime {
    public static void main(String[] args) {
        System.out.println(findLargestPandigitalPrime());
    }

    private static long findLargestPandigitalPrime() {
        long max = 0;
        for (int n = 1; n <= 9; n++) {
            long delegate = findLargestPandigitalPrime(n);
            if (delegate > max) {
                max = delegate;
            }
        }
        return max;

    }

    private static int findLargestPandigitalPrime(int n) {
        String pandigital = "";
        for (int i = 1; i <= n; i++) {
            pandigital += i;
        }
        ArrayList<String> pandigitals = generateAllPermutation(Integer.parseInt(pandigital));
        int max = 0;
        for (String num : pandigitals) {
            int number = Integer.parseInt(num);
            if (isPrime(number) && number > max) {
                max = number;
            }
        }
        return max;

    }

    public static boolean isPrime(long n) {
        if (n == 1 || n == 2) {
            return true;
        }
        for (int j = 2; j < Math.sqrt(n) + 1; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<String> generateAllPermutation(int number) {
        ArrayList<String> list = new ArrayList<>();
        String num = String.valueOf(number);
        for (int i = 0; i < num.length(); i++) {
            list.add(String.valueOf(num.charAt(i)));
        }
        return generateAllPermutation(list);

    }

    private static ArrayList<String> generateAllPermutation(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> copy = (ArrayList<String>) list.clone();
            copy.remove(i);
            ArrayList<String> permutations = generateAllPermutation(copy);
            for (String p : permutations) {
                result.add(list.get(i) + p);
            }
        }
        return result;


    }
}

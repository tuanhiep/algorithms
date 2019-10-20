package tuanhiep.usa.algo.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Problem37_TruncatablePrime {
    public static HashSet<Integer> ending = new HashSet<Integer>();

    public static void main(String[] args) {
        ending.add(2);
        ending.add(3);
        ending.add(5);
        ending.add(7);
        System.out.println(checkTruncatablePrime(3797));
        System.out.println(sumElevenPrimes(11));
    }

    private static long sumElevenPrimes(int total) {
        int count = 0;
        long number = 8;
        long sum = 0;
        while (count < total) {
            if (checkTruncatablePrime(number)) {
                count++;
                sum += number;
            }
            number++;

        }
        return sum;


    }

    private static boolean checkTruncatablePrime(long number) {

        ArrayList<Integer> lr = truncateLeftToRight(number);
        ArrayList<Integer> rl = truncateRightToLeft(number);
        if (!checkValidEnding(lr, true) || !checkValidEnding(rl, false)) {
            return false;
        }
        return checkPrime(lr) && checkPrime(rl);

    }

    private static boolean checkPrime(ArrayList<Integer> array) {
        for (int i : array) {
            if (!isPrime(i)) {
                return false;
            }
        }

        return true;
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

    private static boolean checkValidEnding(ArrayList<Integer> array, boolean head) {
        if (head) {
            return ending.contains(array.get(0));
        }
        return ending.contains(array.get(array.size() - 1));


    }

    private static ArrayList<Integer> truncateRightToLeft(long number) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        while (number / Math.pow(10, i) > 1) {
            result.add((int) (number / Math.pow(10, i)));
            i++;

        }
        return result;


    }

    private static ArrayList<Integer> truncateLeftToRight(long number) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 1;
        while (number / Math.pow(10, i) > 0.1) {
            result.add((int) (number % Math.pow(10, i)));
            i++;

        }
        return result;

    }
}

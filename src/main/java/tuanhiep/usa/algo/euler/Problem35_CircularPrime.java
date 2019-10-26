package tuanhiep.usa.algo.euler;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 */
public class Problem35_CircularPrime {
    public static void main(String[] args) {
        System.out.println(generateAllRotation(197));
        System.out.println(isCircularPrime(197));
        System.out.println(countCircularPrime(1000000));

    }

    private static int countCircularPrime(int upper) {
        int count = 0;
        for (int i = 2; i < upper; i++) {
            if (isCircularPrime(i)) {
                count++;
            }
        }
        return count;


    }

    private static boolean isCircularPrime(int number) {
        if (!isPrime(number)) {
            return false;
        }
        ArrayList<String> list = generateAllRotation(number);
        return checkPrime(list);


    }

    private static ArrayList<String> generateAllRotation(int number) {
        ArrayList<String> result = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        String num = String.valueOf(number);
        for (int i = 0; i < num.length(); i++) {
            queue.add(String.valueOf(num.charAt(i)));
        }
        for (int count = 0; count < num.length(); count++) {
            String removed = queue.poll();
            queue.add(removed);
            String rotation = convertToString(queue);
            if (rotation != "") {
                result.add(rotation);
            }
        }
        return result;

    }

    private static String convertToString(LinkedList<String> queue) {
        String result = "";
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(0) == "0") {
                return "";
            }
            result += queue.get(i);
        }
        return result;
    }

    private static boolean checkPrime(ArrayList<String> list) {
        boolean prime = true;
        for (String num : list) {
            prime = prime && isPrime(Long.parseLong(num));
        }
        return prime;
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

    public static boolean isPrime(long n) {
        if (n < 0) {
            return false;
        }
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
}

package tuanhiep.usa.algo.euler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5_SmallestMultiple {
    public static void main(String[] args) {
        System.out.println(findLeastCommonMultiple(10));
    }


    private static long findGreatestCommonDivisor(long a, long b) {
        if (a % b != 0)
            return findGreatestCommonDivisor(b, a % b);
        else
            return b;

    }

    private static long findLeastCommonMultiple(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++)
            ans = (ans * i) / (findGreatestCommonDivisor(ans, i));
        return ans;
    }


    public static long findLargestCommonMultipleBruteForce(int number) {
        long result = 1;
        boolean searching = true;
        while (searching) {
            boolean detected = true;
            for (int i = 1; i <= number; i++) {
                if (result % i != 0) {
                    detected = false;
                }
            }
            if (!detected) {
                result++;
            } else {
                return result;
            }
        }

        return -1;
    }


}

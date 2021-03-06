package tuanhiep.usa.algo.euler;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3_LargestPrimeFactor {
    public static void main(String[] args) {
        System.out.println(findLargestPrimeFactor(600851475143L));
    }

    public static long findLargestPrimeFactor(long n) {
        int max = 1;
        int factor = 2;
        while (n != 1) {
            long modulo = n % factor;
            if (modulo != 0) {
                factor += 1;
            } else {
                n = n / factor;
                max = Math.max(max, factor);
            }
        }
        return max;

    }
}

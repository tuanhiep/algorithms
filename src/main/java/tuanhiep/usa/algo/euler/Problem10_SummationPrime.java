package tuanhiep.usa.algo.euler;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class Problem10_SummationPrime {
    public static void main(String[] args) {
        System.out.println(findSumPrime(2000000));
    }

    public static long findSumPrime(long n) {
        long sum=0;
        for (long number=2;number < n;number++) {

            if (isPrime(number)) {
                sum += number;
            }
        }
        return sum;

    }

    public static boolean isPrime(long n) {
        if (n==1||n==2) {
            return true;
        }
        for (int j = 2; j < Math.sqrt(n)+1; j++) {
            if (n % j == 0) {
                return  false;
            }
        }
        return true;
    }

}

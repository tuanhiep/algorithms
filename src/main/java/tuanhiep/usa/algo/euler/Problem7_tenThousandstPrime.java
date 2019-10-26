package tuanhiep.usa.algo.euler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
public class Problem7_tenThousandstPrime {
    public static void main(String[] args) {
        System.out.println(findPrimePosition(10001));
    }


    public static long findPrimePosition(int n) {
        int count=1;
        long number=3;
        while (count < n) {
            boolean prime=true;
            if (n == 1 || n == 2) {
                return n;
            }
            for (int j = 2; j < Math.sqrt(number)+1; j++) {
                if (number%j==0) {
                    number++;
                    prime=false;
                    break;
                }
            }
            if (prime) {
                count++;
                number++;
            }
        }
        return number-1;
    }

}

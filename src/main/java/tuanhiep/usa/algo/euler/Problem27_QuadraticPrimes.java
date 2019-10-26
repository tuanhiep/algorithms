package tuanhiep.usa.algo.euler;

/**
 * Euler discovered the remarkable quadratic formula:
 *
 * n2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39. However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41 is clearly divisible by 41.
 *
 * The incredible formula n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n2+an+b, where |a|<1000 and |b|≤1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 */
public class Problem27_QuadraticPrimes {
    public static void main(String[] args) {
        System.out.println(findMaxNumberPrimes(1,41));
        System.out.println(findProductCofficients());
    }

    private static int findProductCofficients() {
        int maxNumber=0;
        int aM=-1001,bM=-1001;
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int maxAB = findMaxNumberPrimes(a, b);
                if (maxAB > maxNumber) {
                    maxNumber=maxAB;
                    aM=a;
                    bM=b;

                }
            }
        }

        return aM * bM;

    }

    private static int findMaxNumberPrimes(int a, int b) {

        int n=0;
        while (true) {
            if (isPrime((long) (Math.pow(n, 2) + a * n + b))) {
                n++;
            } else {
                break;
            }
        }
        return n-1;

    }

    public static boolean isPrime(long n) {
        if (n < 0) {
            return false;
        }
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

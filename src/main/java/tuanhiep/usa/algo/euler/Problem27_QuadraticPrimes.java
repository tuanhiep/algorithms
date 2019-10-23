package tuanhiep.usa.algo.euler;

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

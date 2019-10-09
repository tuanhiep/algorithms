package tuanhiep.usa.algo.euler;

public class tenThousandstPrime {
    public static void main(String[] args) {
        System.out.println(findPrimePosition(10001));
    }

    public static long greatestCommonDivisor(long a, long b) {
        if (a % b != 0) {
            return greatestCommonDivisor(b, a % b);
        } else {
            return b;
        }
    }

    public static long findPrimePosition(int n) {
        int count=1;
        long number=3;
        while (count < n) {
            boolean prime=true;
            if (n == 1 || n == 2) {
                return n;
            }
            for (int j = 2; j < number; j++) {
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

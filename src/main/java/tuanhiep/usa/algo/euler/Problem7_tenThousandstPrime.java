package tuanhiep.usa.algo.euler;

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

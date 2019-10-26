package tuanhiep.usa.algo.euler;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34_DigitFactorials {
    public static void main(String[] args) {
        System.out.println(checkEqualFactorial(145));
        System.out.println(findSumEqualFactorial());

    }

    /**
     *  Here we remark that if the satisfied number has k digits so: minimum of k digits   10^(k-1) <= number <= k*9! with all digits is 9
     *  We have 8*9! is 7 digits number so it's impossible that number is 8 digits number
     * @return
     */
    private static long findSumEqualFactorial() {
        long sum=0;
        for (int i = 3; i < Math.pow(10, 7); i++) {
            if (checkEqualFactorial(i)) {
                sum+=i;
            }
        }
        return sum;
    }

    private static boolean checkEqualFactorial(int num) {
        String number = String.valueOf(num);
        long sum=0;
        for (int i = 0; i < number.length(); i++) {
            int val = Character.getNumericValue(number.charAt(i));
            sum += factorial(val);
        }
        return num == sum;


    }

    private static int factorial(int n)
    {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        for (int i=2; i<=n; i++)
            res *= i;
        return res;
    }
}

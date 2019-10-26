package tuanhiep.usa.algo.euler;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
public class Problem20_FactorialDigitSum {
    public static void main(String[] args) {
        double result = factorialReal(10);
        System.out.println(result + " --- " + sumDigitReal(result));
        String bigResult = factorialString(100);
        System.out.println(bigResult + " --- " + sumDigitString(bigResult));


    }

    private static long sumDigitString(String bigResult) {
        long sum = 0;
        for (int i = 0; i < bigResult.length(); i++) {
            sum += Character.getNumericValue(bigResult.charAt(i));
        }
        return sum;
    }

    private static String factorialString(int n) {
        String result = "1";
        for (int i = 1; i <= n; i++) {
            result = multiplyString(result, String.valueOf(i));
        }
        return result;
    }

    private static String multiplyString(String result, String factor) {
        String sum = "0";
        for (int i = factor.length() - 1; i >= 0; i--) {
            int term = Character.getNumericValue(factor.charAt(i));
            String temp = multiply(result, term);
            int numberZero = factor.length() - 1 - i;
            for (int j = 0; j < numberZero; j++) {
                temp = temp + "0";
            }
            sum = sumString(sum, temp);

        }
        return sum;


    }

    private static String sumString(String s1, String s2) {
        int length = 0;
        if (s1.length() > s2.length()) {
            length = s1.length();
        } else {
            length = s2.length();
        }
        String result = "";
        boolean memo = false;
        for (int i = 0; i < length; i++) {
            int first;
            if (s1.length() - 1 - i < 0) {
                first = 0;
            } else {
                first = Character.getNumericValue(s1.charAt(s1.length() - 1 - i));
            }
            int second;
            if (s2.length() - 1 - i < 0) {
                second = 0;
            } else {
                second = Character.getNumericValue(s2.charAt(s2.length() - 1 - i));
            }

            int sum = first + second;
            if (memo) {
                sum += 1;
            }
            if (sum >= 10) {
                memo = true;
            } else {
                memo = false;
            }
            result = String.valueOf(sum % 10) + result;


        }
        if (memo) {
            result = "1" + result;
        }


        return result;
    }

    private static String multiply(String s, int a) {
        String result = "";
        int memory = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int x = Character.getNumericValue(s.charAt(i)) * a;
            int modulo = (memory + x) % 10;
            memory = (memory + x) / 10;
            result = String.valueOf(modulo) + result;

        }
        if (memory > 0) {
            result = String.valueOf(memory) + result;
        }
        return result;
    }


    // Use double type in java but this solution has limitation of double type java
    private static long sumDigitReal(double number) {
        int sum = 0;
        long digit = getLengthReal(number);
        long base = digit - 1;
        double term = number;
        while (term > 10) {
            int head = (int) (term / Math.pow(10, base));
            sum += head;
            term = term % Math.pow(10, base);
            base = base - 1;
        }
        sum += term;

        return sum;
    }

    private static long getLengthReal(double number) {
        int digit = 0;
        double term = number;
        while (term > 1) {
            term = term / 10;
            digit++;
        }
        return digit;
    }

    private static double factorialReal(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


}

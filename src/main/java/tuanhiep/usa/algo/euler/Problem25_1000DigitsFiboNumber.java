package tuanhiep.usa.algo.euler;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25_1000DigitsFiboNumber {
    public static void main(String[] args) {
        System.out.println(getNumberDigits("123456789"));
        System.out.println(findFiboContainNdigits(1000));
    }

    private static long findFiboContainNdigits(int n) {
        String f1 = "1", f2 = "1";
        String fn;
        int index = 2;
        while (true) {
            fn = sumString(f1,f2) ;
            index = index + 1;
            if (getNumberDigits(fn) == n) {
                break;
            }
            f1 = f2;
            f2 = fn;

        }
        return index;
    }

    /**
     * Get number digit of a positive integer
     * @param fn
     * @return
     */
    private static int getNumberDigits(String fn) {

        return fn.length();


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

}

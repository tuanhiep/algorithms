package tuanhiep.usa.algo.euler;

import static java.lang.Math.pow;

public class LargestPalindromeProduct_4 {
    public static void main(String[] args) {
        long[] result= findLargestPalindrome();
        System.out.println(result[0]+"    "+result[1]);

    }
    public static long[] findLargestPalindrome() {
        long min = 100 * 100;
        long max= 999*999;
        long[] result= new long[2];
        for (int a=9;a>=1;a--) {
            for (int b=9;b>=0;b--) {
                if(b==0)System.out.println("Hello"+b);
                for (int c=9;c>=0;c--) {

                    long number = (long) (a * (pow(10, 5) + 1)+ b*(pow(10,4)+10)+c*(pow(10,3)+100));

                    if (number <= max && number >= min) {
                        for (int factor = 100; factor < 999; factor++) {
                            if ((number%factor)==0 && (number/factor) >=100 && (number/factor)<=999) {
                                System.out.println(a);
                                result[0] = Math.max(number,result[0]);
                            }
                        }



                    }


                }
            }
        }
        return result;
    }
}

package tuanhiep.usa.algo.euler;

public class Problem30_DigitFifthPowers {
    public static void main(String[] args) {
        System.out.println(checkPower(1634,4));
        System.out.println(checkPower(8208,4));
        System.out.println(checkPower(9474,4));
        System.out.println(sumDigitFifthPower());

    }

    private static long sumDigitFifthPower() {
        long sum=0;
        for (int i = 10; i <= 999999; i++) {// Because 7*9^5 =413343 is 6 digits number so impossible a number which has 7 digits can has sum of fifth power digits is equal to that number
            if (checkPower(i,5)) {
                sum += i;
            }
        }
        return sum;


    }

    private static boolean checkPower(int number,int p) {
        String num = String.valueOf(number);
        int sumFifthPower=0;
        for (int i = 0; i < num.length(); i++) {
            int val = Character.getNumericValue(num.charAt(i));
            sumFifthPower += Math.pow(val,p);
        }

        return sumFifthPower == number;



    }
}

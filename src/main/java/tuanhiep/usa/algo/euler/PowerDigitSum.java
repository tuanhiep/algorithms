package tuanhiep.usa.algo.euler;

public class PowerDigitSum {
    public static void main(String[] args) {
        System.out.println(multiply("15",2));
        System.out.println(power(3,3));
        System.out.println(powerDigitSum(2,1000));
    }

    private static long powerDigitSum(int a, int b) {
        String pow = power(2, 1000);
        int sum=0;
        for (int i = 0; i < pow.length(); i++) {
            sum += Character.getNumericValue(pow.charAt(i));
        }
        return sum;
    }

    private static String power(int a, int b) {
        String result="1";
        for (int i = 0; i < b; i++) {
            result=multiply(result,a);
        }
        return result;
    }

    private static String multiply(String s, int a) {
        String result="";
        int memory=0;
        for (int i= s.length()-1;i>=0;i--) {
            int x= Character.getNumericValue(s.charAt(i))*a;
            int modulo= memory+ x%10;
            memory =x/10;
            result=String.valueOf(modulo)+result;

        }
        if (memory > 0) {
            result=String.valueOf(memory)+result;
        }
        return result;
    }
}

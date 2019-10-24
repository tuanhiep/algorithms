package tuanhiep.usa.algo.euler;

public class Problem40_ChampernowneConstant {
    public static String chain="0";
    public static int index=0;

    public static void main(String[] args) {

        System.out.println(getDigit(1));
        System.out.println(getDigit(2));
        System.out.println(getDigit(3));
        System.out.println(getDigit(11));
        System.out.println(getDigit(12));
        System.out.println(getDigit(1000));
        System.out.println(findValue());
    }

    private static int findValue() {
        return getDigit(1)*getDigit(10)*getDigit(100)*getDigit(1000)*getDigit(10000)*getDigit(100000)*getDigit(1000000);
    }

    private static int getDigit(int position) {
        while (position >= chain.length()) {
            index++;
            chain += String.valueOf(index);
        }
        return Character.getNumericValue(chain.charAt(position));

    }
}

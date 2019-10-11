package tuanhiep.usa.algo.euler;

import java.util.HashMap;

public class NumberLetterCount_17 {
    static HashMap<Integer, Integer> alpha = new HashMap<>();


    public static void main(String[] args) {
        alphabetize();
        System.out.println(countSum(1000));
    }

    private static void alphabetize() {
        alpha.put(1, "ONE".length());
        alpha.put(2, "TWO".length());
        alpha.put(3, "THREE".length());
        alpha.put(4, "FOUR".length());
        alpha.put(5, "FIVE".length());
        alpha.put(6, "SIX".length());
        alpha.put(7, "SEVEN".length());
        alpha.put(8, "EIGHT".length());
        alpha.put(9, "NINE".length());
        alpha.put(10, "TEN".length());
        alpha.put(11, "ELEVEN".length());
        alpha.put(12, "TWELVE".length());
        alpha.put(13, "THIRTEEN".length());
        alpha.put(14, "FOURTEEN".length());
        alpha.put(15, "FIFTEEN".length());
        alpha.put(16, "SIXTEEN".length());
        alpha.put(17, "SEVENTEEN".length());
        alpha.put(18, "EIGHTEEN".length());
        alpha.put(19, "NINETEEN".length());
        alpha.put(20, "TWENTY".length());
        alpha.put(30, "THIRTY".length());
        alpha.put(40, "FORTY".length());
        alpha.put(50, "FIFTY".length());
        alpha.put(60, "SIXTY".length());
        alpha.put(70, "SEVENTY".length());
        alpha.put(80, "EIGHTY".length());
        alpha.put(90, "NINETY".length());

    }

    private static long countSum(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += speakOut(i);
        }
        return result;
    }

    private static long speakOut(int i) {
        if (alpha.containsKey(i)) {
            return alpha.get(i);
        }
        if ((i > 0 && i < 20)) {
            return alpha.get(i);
        }
        if (i >= 21 && i <= 99) {
            int modulo = i % 10;
            int complement = i - modulo;
            int count = alpha.get(complement) + alpha.get(modulo);
            alpha.put(i, count);
            return count;
        }
        if (i >= 100 && i <= 999) {
            int hundred = i / 100;
            int complement = i % 100;
            return complement > 0 ? alpha.get(hundred) + "HUNDRED".length() + "AND".length() + alpha.get(complement) : alpha.get(hundred) + "HUNDRED".length();
        }
        if (i == 1000) {
            return "ONE".length() + "THOUSAND".length();
        }
        return 0;
    }


}
package tuanhiep.usa.algo.euler;

import java.util.HashMap;

public class HighlyDivisibleTriangleNumber_12 {
    public static void main(String[] args) {
        System.out.println(findTriangleNumber(500));
    }

    public static HashMap<Integer, Integer> memo = new HashMap<>();

    public static long findTriangleNumber(int n) {

        int countDivisor = 0;
        int position = 2;
        while (countDivisor <= n) {
            if (position % 2 == 0) {
                countDivisor = getNumberDivisor(position / 2) * getNumberDivisor(position + 1);

            } else {
                countDivisor = getNumberDivisor((position + 1) / 2) * getNumberDivisor(position);

            }
            position++;

        }
        return generateTriangleNumner(position - 1);
    }

    private static int getNumberDivisor(int number) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }
        int count = 0;
        for (int i = 1; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                if (i != number / i) {
                    count += 2;

                } else {
                    count++;
                }
            }
        }
        memo.put(number, count);
        return count;
    }


    private static long generateTriangleNumner(int position) {
        return (position + 1) * position / 2;

    }


}

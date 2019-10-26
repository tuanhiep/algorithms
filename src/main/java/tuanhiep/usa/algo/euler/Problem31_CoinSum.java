package tuanhiep.usa.algo.euler;

import java.util.HashMap;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class Problem31_CoinSum {
    public static HashMap<String, Long> memo = new HashMap<>();
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200};
        System.out.println(makeChange(200, denominations, 0));
    }

    private static long makeChange(int amount, int[] denominations, int index) {
        if (amount == 0) {
            return 1;
        }
        if (index >= denominations.length) {
            return 0;
        }
        String key = amount + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long way = 0;
        int coinSum = 0;
        while (coinSum <= amount) {
            int remaining = amount - coinSum;
            way += makeChange(remaining, denominations, index + 1);
            coinSum += denominations[index];
        }

        memo.put(key, way);
        return way;
    }

}

package tuanhiep.usa.algo.cracking;

import java.util.HashMap;

public class CoinChange {
    public static void main(String[] args) {

    }


    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<String, Long>());
    }

    /**
     * Solve the problem of make change an amount of money with predefined set of denominations
     *
     * @param coins
     * @param money
     * @param index
     * @param memo
     * @return
     */
    public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        int amountWithCoins = 0;
        long ways = 0;
        String key = money + "-" + index;
//        Memorization technique to not compute the same problem again
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        while (amountWithCoins < money) {
            int remaining = money - amountWithCoins;
            ways += makeChange(coins, remaining, index + 1, memo);
            amountWithCoins += coins[index];
        }
//        Memorization technique to not compute the same problem again
        memo.put(key, ways);
        return ways;

    }


}











































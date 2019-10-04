package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;
import tuanhiep.usa.common.utils.TypeAlgo;

import java.util.ArrayList;

public class CoinChange extends abstractAlgo {


    @Override
    public void setUpDefault() {
        ArrayList parametersDefault = new ArrayList();
        int total = 27;
        int[] denominations = {25, 10, 5, 1};
        parametersDefault.add(total);
        parametersDefault.add(denominations);
        this.setParameters(parametersDefault);
        this.setName("Algorithm solves Coin Change problem");
        this.setType(TypeAlgo.DATA_STRUCTURE);
        this.setDescription("We use algorithm to solve the problem of making change with a number of predefined denominations ");

    }

    @Override
    public void run() {
        int total = (int) this.getParameters().get(0);
        int[] denominations = (int[]) this.getParameters().get(1);
        int[][] surplus = new int[denominations.length][];
        int rest = total;
        for (int i = 0; i < denominations.length; i++) {
            surplus[i][0] = rest;
            surplus[i][1] = denominations[i];
            surplus[i][2] = rest / denominations[i];
            surplus[i][3] = rest % denominations[i];

        }


    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0);
    }


    public static long makeChange(int[] coins, int money, int index) {
        if (money == 0) {
            return 1;
        }
        if (index > coins.length) {
            return 0;
        }
        int amountWithCoins = 0;
        long ways = 0;
        while (amountWithCoins < money) {
            int remaining = money - amountWithCoins;
            ways += makeChange(coins, remaining, index + 1);
            amountWithCoins += coins[index];
        }
        return ways;

    }


}











































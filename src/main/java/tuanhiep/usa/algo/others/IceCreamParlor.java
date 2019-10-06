package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class IceCreamParlor extends abstractAlgo {
    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    /**
     * Find choices for cream in menu with an amount of money given
     * Hypothesis there are not more than 2 creams which has the same price
     *
     * @param menu
     * @param money
     * @return
     */
    public ArrayList<int[]> findChoices(int[] menu, int money) {
        ArrayList<int[]> result = new ArrayList<>();

        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);
        for (int firstIndex = 0; firstIndex < sortedMenu.length; firstIndex++) {

            int complement = money - sortedMenu[firstIndex];
            int secondIndex = Arrays.binarySearch(sortedMenu, firstIndex + 1, sortedMenu.length, complement);
            if (secondIndex > 0 && secondIndex < sortedMenu.length) {

                int[] creamIndex = new int[2];
                creamIndex[0] = getCreamIndex(sortedMenu[firstIndex], menu, -1);
                creamIndex[1] = getCreamIndex(complement, menu, creamIndex[0]);


                result.add(creamIndex);
            }
        }

        return result;
    }

    private int getCreamIndex(int creamPrice, int[] menu, int excludedIndex) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == creamPrice && i != excludedIndex) {
                return i;
            }
        }


        return -1;
    }


}

package tuanhiep.usa.algo.euler;

import java.util.HashMap;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem26_ReciprocalCycles {

    public static void main(String[] args) {
        System.out.println(getCycle(7));
        System.out.println(findLongestCycleD(1000));
    }

    private static int findLongestCycleD(int limit) {
        int maxCycle = 1;
        int target = 1;
        int tmp = 1;
        for (int i = 2; i < limit; i++) {
            tmp = getCycle(i);
            if (tmp > maxCycle) {
                maxCycle = tmp;
                target = i;
            }
        }
        return target;


    }

    private static int getCycle(int d) {
        HashMap<Integer, Integer> mapCycle = new HashMap<>();
        int modulo = 10 % d;
        int count = 0;
        while (!mapCycle.containsKey(modulo)) {
            mapCycle.put(modulo, count);
            modulo=10*modulo%d;
            count++;
        }
        return count - mapCycle.get(modulo);

    }
}

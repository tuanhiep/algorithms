package tuanhiep.usa.algo.euler;

import java.util.HashMap;

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

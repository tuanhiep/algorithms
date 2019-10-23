package tuanhiep.usa.algo.euler;

import java.util.HashSet;

public class Problem29_DistinctPowers {
    public  static HashSet<Double> store = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(findNumberDistinctPowers(2,100));

    }

    private static int findNumberDistinctPowers(int lower, int upper) {
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                store.add(Math.pow(a, b));
            }
        }
        return store.size();
    }
}

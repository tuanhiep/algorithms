package tuanhiep.usa.algo.euler;

import java.util.HashMap;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 *
 * How many such routes are there through a 20×20 grid?
 */
public class Problem15_LatticePaths {
    HashMap<String, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(findSteps(2));
        System.out.println(findSteps(20));

    }


    public static long findSteps(int grid) {

        long[][] memo = new long[grid + 1][grid + 1];
        memo[grid][grid] = 1;
        for (int i = grid; i >= 0; i--) {
            for (int j = grid; j >= 0; j--) {
                if (i + 1 <= grid) {
                    memo[i][j] = memo[i + 1][j];
                }
                if (j + 1 <= grid) {
                    memo[i][j] += memo[i][j + 1];
                }
            }
        }
        return memo[0][0];

    }
}
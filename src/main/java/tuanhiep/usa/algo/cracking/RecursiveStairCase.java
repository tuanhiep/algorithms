package tuanhiep.usa.algo.cracking;

public class RecursiveStairCase {
    public static void main(String[] args) {

    }

    /**
     * get ways to leap with memorization technique
     *
     * @param steps
     * @return
     */
    public int getWayToLeap(int steps) {
        return getWayToLeap(steps, new int[steps + 1]);
    }

    public int getWayToLeap(int steps, int[] memo) {

        if (steps == 0) {
            return 1;
        }
        if (steps == 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        // Memorization technique
        if (memo[steps] == 0) {
            memo[steps] = getWayToLeap(steps - 1) + getWayToLeap(steps - 2) + getWayToLeap(steps - 3);

        }
        return memo[steps];
    }

    /**
     * Get ways to leap by dynamic programming approach
     *
     * @param steps
     * @return
     */
    public int getWaysLeapDynamic(int steps) {
        if (steps == 0) {
            return 1;
        }
        if (steps == 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        int[] stairCase = new int[steps + 1];
        stairCase[0] = 1;
        stairCase[1] = 1;
        stairCase[2] = 2;
        for (int i = 3; i < steps; i++) {
            stairCase[i] = stairCase[i - 1] + stairCase[i - 2] + stairCase[i-3];
        }

        return stairCase[steps];

    }

    /**
     * Get ways to leap by permutation programming approach
     *
     * @param steps
     * @return
     */
    public int getWaysLeapPermutation(int steps) {
        int[] stairCase = {1, 1, 2};
        int count=0;
        for (int i = 3; i < steps; i++) {
            count = stairCase[0] + stairCase[1] + stairCase[2];
            stairCase[0] = stairCase[1];
            stairCase[1] = stairCase[2];
            stairCase[2] = count;
        }

        return stairCase[2];

    }


}

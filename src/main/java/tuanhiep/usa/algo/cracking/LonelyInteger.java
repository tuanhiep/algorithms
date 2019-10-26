package tuanhiep.usa.algo.cracking;

public class LonelyInteger {
    public static void main(String[] args) {
        System.out.println(lonelyInteger(new int[]{1,2,3,4,5,2,3,4,1}));
    }

    /**
     * Find the lonely Integer int an array of integer
     * @param array
     * @return
     */
    private static int lonelyInteger(int[] array) {
        int result = 0;
        for (int i : array) {
            result ^= i;
        }
        return result;


    }
}

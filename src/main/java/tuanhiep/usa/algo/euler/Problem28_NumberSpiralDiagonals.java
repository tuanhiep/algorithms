package tuanhiep.usa.algo.euler;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem28_NumberSpiralDiagonals {
    public static void main(String[] args) {
        System.out.println(sumDiagonal(1001));

    }

    private static long sumDiagonal(int n) {
        int numLevel = (n - 1) / 2;
        long sum= sumMainDiagonal(numLevel)+sumSubDiagonal(numLevel) -1;
        return sum;



    }

    private static long sumSubDiagonal(int numLevel) {
        long sum=0;
        for (int i = 1; i <= numLevel; i++) {
            sum += Math.pow(2*i + 1, 2) - (2*i) + Math.pow(2*i + 1, 2) - 3 * (2*i);
        }
        return sum+1;


    }

    private static long sumMainDiagonal(int numLevel) {
        long sum=0;
        for (int i = 1; i <= numLevel; i++) {
            sum += Math.pow(2*i+1,2)+ Math.pow(2*i+1,2)-2*(2*i);
        }
        return sum+1;
    }
}

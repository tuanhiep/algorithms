package tuanhiep.usa.algo.euler;

/**
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6_SumSquareDifference {
    public static void main(String[] args) {
        System.out.println(findSumSquareDifference(100));
    }

    public static long findSumSquareDifference(int n) {
        long sum=0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <=  n; j++) {
                if (i!=j) {
                    sum+=2*i*j;
                }
            }
        }
        return sum;

    }
}

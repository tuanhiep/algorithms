package tuanhiep.usa.algo.euler;

/**
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9_SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        System.out.println(findTriplet(1000));

    }

    public static long findTriplet(int sum) {
        for (int a = 1; a < sum; a++) {
            for (int b = 1; b < sum; b++) {
                if ((2 * sum * (a + b) - 2 * a * b) == Math.pow(sum, 2)) {
                    int c= (int) Math.pow(a*a+b*b,0.5);
                    return a*b*c;
                }
            }
        }
        return -1;
    }


}

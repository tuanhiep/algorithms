package tuanhiep.usa.algo.euler;

public class SmallestMultiple {
    public static void main(String[] args) {
        System.out.println(findLargestCommonMultiple(10));
    }


    private static long findGreatestCommonDivisor(long a, long b) {
        if (a % b != 0)
            return findGreatestCommonDivisor(b, a % b);
        else
            return b;

    }

    private static long findLargestCommonMultiple(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++)
            ans = (ans * i) / (findGreatestCommonDivisor(ans, i));
        return ans;
    }


    public static long findLargestCommonMultipleBruteForce(int number) {
        long result = 1;
        boolean searching = true;
        while (searching) {
            boolean detected = true;
            for (int i = 1; i <= number; i++) {
                if (result % i != 0) {
                    detected = false;
                }
            }
            if (!detected) {
                result++;
            } else {
                return result;
            }
        }

        return -1;
    }


}

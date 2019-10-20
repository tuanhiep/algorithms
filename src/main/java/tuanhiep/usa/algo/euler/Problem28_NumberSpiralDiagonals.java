package tuanhiep.usa.algo.euler;

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

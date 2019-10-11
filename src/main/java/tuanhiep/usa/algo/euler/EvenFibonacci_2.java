package tuanhiep.usa.algo.euler;

public class EvenFibonacci_2 {

    public static void main(String[] args) {

        System.out.println(EvenFibonacci_2.sumEvenFibonacci(4000000));

    }

    public static int sumEvenFibonacci(int n) {
        int fibo0 = 1;
        int fibo1 = 2;
        int generatedFibo = 0;
        int sum = 2;

        while (generatedFibo <= n) {
            generatedFibo = fibo0 + fibo1;
            fibo0 = fibo1;
            fibo1 = generatedFibo;
            if ((generatedFibo %2) == 0) {
                sum += generatedFibo;
            }

        }
        return sum;
    }
}

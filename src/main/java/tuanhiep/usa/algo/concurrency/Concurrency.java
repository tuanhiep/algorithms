package tuanhiep.usa.algo.concurrency; /**
 * Name: Tuan Hiep TRAN
 * Purpose: This program will calculate the min, max, average of the elements in matrix by using concurrency concept
 * Assumption: The multi-threading concept is used to separate tasks and then speed up the program
 * The main program realize MAX_COUNT times of experiments for each size of matrix by calling the function
 * doExperiment()
 * This function then created matrix with random value for the given size, then find min, max, average
 * The ExecutorService is used to have thread-pool, because we use multi-threading to create matrix and then calculate
 * statistic values so we have 2 ExecutorServices:  executorServiceCreator, executorServiceCalculator
 * To use the mentioned ExecutorService, 2 Callable classes are implemented : RandomRow and ProcessRow
 * The function awaitTerminationAfterShutdown() is implemented to wait all threads which are started by invokeAll() of
 * ExecutorService, to finished.
 * Then the function getStatistics() give us the desired statistics: average, standard deviation
 */


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Concurrency {
    // max time waiting a thread to finish in seconds
    static int maxTimeWait = 10 * 60;
    // size of matrix
    static int[] N = {2, 4, 8, 12, 16};
    // maximum times to do experiment with one size of matrix
    static int MAX_COUNT = 5;

    public static void main(String[] args) {
        long startTime;
        long endTime;
        long timeElapsed;
        long[] duration = new long[MAX_COUNT];
        for (int n : N) {
            for (int count = 0; count < MAX_COUNT; count++) {
                System.out.println("\nMatrix size = " + n + " Experiment: " + count);
                startTime = System.nanoTime();
                // do the experiment with matrix size n
                doExperiment(n);
                endTime = System.nanoTime();
                timeElapsed = endTime - startTime;
                System.out.println("Execution time in nanoseconds: " + timeElapsed);
                System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
                duration[count] = timeElapsed;
            }
            // print out the duration to plot data
            System.out.print("\nTime (nanoseconds) elapsed for matrix size = " + n + " each time : ");
            for (int count = 0; count < MAX_COUNT; count++) {
                System.out.print(duration[count] + ", ");
            }
            float[] stats = getStatistics(duration);
            System.out.print("Average time: " + stats[0] + " Standard deviation : " + stats[1]);
        }
    }

    /**
     * Calculate the standard deviation of elements in an array
     *
     * @param array
     * @return
     */
    private static float[] getStatistics(long[] array) {
        float[] result = new float[2];
        long total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i]; // this is the calculation for summing up all the values
        }
        float mean = total / array.length;
        result[0] = mean;
        float sd = 0;
        for (int i = 0; i < array.length; i++) {
            sd = (float) (sd + Math.pow(array[i] - mean, 2));
        }
        result[1] = (float) Math.sqrt(sd / (array.length - 1));

        return result;
    }

    private static void doExperiment(int n) {
        int size = n;
        try {
            ExecutorService executorServiceCreator = Executors.newFixedThreadPool(size);
            ExecutorService executorServiceCalculator = Executors.newFixedThreadPool(size);
            // create matrix with given size by random value
            float[][] matrix = createMatrix(executorServiceCreator, size);
            // calculate min, max, average of elements in matrix
            float[] result = calculateMatrix(executorServiceCalculator, matrix);
            System.out.println("Min: " + result[0] + " Max: " + result[1] + " Average: " + result[2]);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    /**
     * Calculate the min, max and average of matrix
     *
     * @param matrix
     * @return
     * @throws InterruptedException
     */
    private static float[] calculateMatrix(ExecutorService executorService, float[][] matrix) throws InterruptedException, ExecutionException {
        List<Callable<float[]>> callableList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            callableList.add(new ProcessRow(matrix[i]));
        }
        // This list store the result for each processed row in matrix
        List<Future<float[]>> futures = executorService.invokeAll(callableList);
        awaitTerminationAfterShutdown(executorService);
        float[] firstRow = futures.get(0).get();
        float[] result = new float[3];
        result[0] = firstRow[0];
        result[1] = firstRow[1];
        result[2] = 0;

        for (Future f : futures) {
            float[] resultRow = (float[]) f.get();
            // Get the min of matrix is also the min of {min of each row}
            if (resultRow[0] < result[0]) {
                result[0] = resultRow[0];
            }
            // Get the max of matrix is also the max of {max of each row}
            if (resultRow[1] > result[1]) {
                result[1] = resultRow[1];
            }
            result[2] += resultRow[2];
        }
        // Calculate the average of matrix = average of {average of each row}
        result[2] = result[2] / matrix.length;
        return result;

    }

    /**
     * Wait all the threads invoked to be finished within maxTimeWait duration
     *
     * @param threadPool
     */
    public static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(maxTimeWait, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * create matrix with random value in the range of between 2^(32-N) and 2^(31-N).
     *
     * @param size
     * @return
     */
    private static float[][] createMatrix(ExecutorService executorService, int size) throws InterruptedException, ExecutionException {

        List<Callable<float[]>> callableList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            callableList.add(new RandomRow(size));
        }
        List<Future<float[]>> futures = executorService.invokeAll(callableList);
        awaitTerminationAfterShutdown(executorService);
        float[][] matrix = new float[size][];
        for (int i = 0; i < size; i++) {
            matrix[i] = futures.get(i).get();
        }
        return matrix;
    }

}

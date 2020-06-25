package tuanhiep.usa.algo.concurrency; /**
 * Name: Tuan Hiep TRAN
 * Date: 11/15/2019
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

import java.util.concurrent.Callable;

/**
 * Callable class to created random elements for row in matrix
 */
public class RandomRow implements Callable<float[]> {
    int lengthRow;
    float min;
    float max;

    public RandomRow(int size) {
        lengthRow = size;
        //  randomly assign values to each element in the range of  between 2^(32-N) and 2^(31-N).
        min = (float) Math.pow(2, 32 - size);
        max = (float) Math.pow(2, 31 - size);
    }

    @Override
    public float[] call() throws Exception {
        float[] row = new float[lengthRow];
        for (int i = 0; i < lengthRow; i++) {
            row[i] = (float) (min + Math.random() * (max - min));
        }
        return row;
    }
}

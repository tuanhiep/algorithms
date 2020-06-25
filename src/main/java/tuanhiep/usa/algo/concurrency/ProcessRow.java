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

import java.util.concurrent.Callable;

/**
 * This is callable class to process one row of a matrix
 */
public class ProcessRow implements Callable<float[]> {
    float[] row;

    public ProcessRow(float[] rowMatrix) {
        row = rowMatrix;
    }

    @Override
    public float[] call() throws Exception {
        float[] result = new float[3];
        result[0] = row[0];// to store min of the row
        result[1] = row[0];// to store max of the row
        result[2] = 0;// to store average of row
        for (int i = 0; i < row.length; i++) {
            if (row[i] < result[0]) {
                result[0] = row[i];
            }
            if (row[i] > result[1]) {
                result[1] = row[i];
            }
            result[2] += row[i];
        }
        result[2] = result[2] / row.length;
        return result;
    }
}

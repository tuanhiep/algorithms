package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianByHeap extends abstractAlgo {
    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    /**
     *  Get the continous medians for sequence of number given from an array
     * @param array
     * @return
     */
    public double[] getMedian(int[] array) {
        PriorityQueue<Integer> lower= new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1* o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        double[] medians = new double[array.length];

        for (int number=0; number<array.length;number++) {
            addNumberHeap(array[number], lower, higher);
            reBalanceHeap(lower,higher);
            medians[number]= getMedianHeap(lower,higher);
        }
        return medians;


    }

    /**
     * Rebalance the size of 2 heaps
     * @param lower
     * @param higher
     */
    private void reBalanceHeap(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;
        if ((biggerHeap.size()-smallerHeap.size())>=2) {
            smallerHeap.add(biggerHeap.poll());

        }
    }

    /**
     * Add the new number to one of 2 heaps
     * @param number
     * @param lower
     * @param higher
     */
    private void addNumberHeap(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        // We do like that because we don't want the heap to be restructured each time we add new element and
        // we can keep the min of higher heap is not less than the max of lower heap
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }

    }

    /**
     * Get the median from 2 heaps
     * @param lower
     * @param higher
     * @return
     */
    private double getMedianHeap(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (higher.size()>lower.size()) {
            return higher.peek();
        }
        if (higher.size()<lower.size()) {
            return lower.peek();
        }
        if (higher.size() == lower.size()) {
            return (higher.peek()+(double)lower.peek())/2;
        }
        return -1;
    }


}

package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

public class LonelyInteger extends abstractAlgo {


    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    /**
     * Solve the problem of lonely integer in an array of integer by using bit operation approach
     * @param array
     * @return
     */
    private int lonelyInteger(int[] array) {
        int result=0;
        for (int value: array) {
            result ^= value;
        }
        return result;
    }



    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }
}

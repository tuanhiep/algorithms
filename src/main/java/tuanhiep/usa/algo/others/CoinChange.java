package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;
import tuanhiep.usa.common.utils.TypeAlgo;

import java.util.ArrayList;

public class CoinChange extends abstractAlgo {


    @Override
    public void setUpDefault() {
        ArrayList parametersDefault = new ArrayList();
        int total=27;
        int[] denominations = {25, 10, 5, 1};
        parametersDefault.add(total);
        parametersDefault.add(denominations);
        this.setParameters(parametersDefault);
        this.setName("Algorithm solves Coin Change problem");
        this.setType(TypeAlgo.OTHERS);
        this.setDescription("We use algorithm to solve the problem of making change with a number of predefined denominations ");

    }

    @Override
    public void run() {
        int total = (int) this.getParameters().get(0);
        int[] denominations = (int[]) this.getParameters().get(1);




    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }
}

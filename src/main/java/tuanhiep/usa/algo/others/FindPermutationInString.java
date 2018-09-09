package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;
import tuanhiep.usa.common.utils.TypeAlgo;

public class FindPermutationInString extends abstractAlgo {

    public void setUpDefault() {
        // a is string to find
        String key = "xacxzaa";
        // b is the target string we need to search in it
        String target = "fxaazxacaaxzocc";
        // put a as first parameter
        this.getParameters().add(key);
        // put b as second parameter
        this.getParameters().add(target);
    }

    public FindPermutationInString() {
        this.setName("FindPermutationInString");
        this.setDescription("Find all the permutations of string a in another string b ");
        this.setType(TypeAlgo.SEARCH);
        setUpDefault();
    }

    public void run() {

    }

    public Object getResult() {

        return null;
    }
}

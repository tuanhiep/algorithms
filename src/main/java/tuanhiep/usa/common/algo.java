package tuanhiep.usa.common;

import java.util.ArrayList;
import java.util.List;

public interface algo {
    public void setUpDefault();
    public void run();
    public void test(ArrayList args);
    // set up the default value as corresponding parameters that need to do the algorithm
    public Object getResult();
    public void print();
}

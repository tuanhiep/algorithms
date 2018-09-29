package tuanhiep.usa.common;

import java.util.ArrayList;

public interface algo {
    void setUpDefault();
    void run();
    void test(ArrayList args);
    // set up the default value as corresponding parameters that need to do the algorithm
    Object getResult();
    void print();
}

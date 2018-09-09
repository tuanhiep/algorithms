package tuanhiep.usa.common;

import tuanhiep.usa.common.utils.TypeAlgo;

import java.util.ArrayList;

public abstract class abstractAlgo implements algo {
    private String name = "";
    private ArrayList parameters = new ArrayList();

    public void test(ArrayList args) {
        // set the parameters to test
        if (args.size() > 0) {
            for (int i = 0; i < args.size(); i++) {
                getParameters().set(i, args.get(i));
            }
        }
        else setUpDefault();
        run();
    }

    public ArrayList getParameters() {
        return parameters;
    }


    public void setParameters(ArrayList parameters) {
        this.parameters = parameters;
    }

    public TypeAlgo getType() {
        return type;
    }

    public void setType(TypeAlgo type) {
        this.type = type;
    }

    private TypeAlgo type;
    private String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package tuanhiep.usa.common.utils;

public enum TypeAlgo {
    SEARCH("search"),
    CLASSIFY("classify"),
    SORT("sort"),
    DATA_STRUCTURE("data structure"),
    OTHERS("others");
    private String type;

    TypeAlgo(String s) {
        this.type = s;
    }
}

package tuanhiep.usa.algo.euler;

import java.util.HashMap;
import java.util.HashSet;

public class Problem39_IntegerRightTriangle {
    public static HashSet<String> considered = new HashSet<>();
    public static HashMap<Integer,Integer> memoSquare = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(countSolution(120));
        System.out.println(findNumberSolution(1000));

    }

    private static int findNumberSolution(int upper) {
        int max = 0;
        int bestP=0;
        for (int p = 1; p <= upper; p++) {
            int count = countSolution(p);
            if (count > max) {
                max = count;
                bestP=p;
            }
        }
        return bestP;

    }

    private static int countSolution(int p) {
        considered.clear();
        int count = 0;
        for (int a = 1; a < p-2*a; a++) {
            for (int b = 1; b < p-2*a; b++) {
                int squareA, squareB, squareC;
                if (considered.contains(a + "-" + b)) {
                    continue;
                } else {
                    int c= p-a-b;
                    if (memoSquare.containsKey(a)) {
                        squareA = memoSquare.get(a);
                    }
                    else{
                        squareA = (int) Math.pow(a, 2);
                        memoSquare.put(a, squareA);
                    }
                    if (memoSquare.containsKey(b)) {
                        squareB = memoSquare.get(b);
                    } else{
                        squareB = (int) Math.pow(b, 2);
                        memoSquare.put(b, squareB);
                    }

                    if (memoSquare.containsKey(c)) {
                        squareC = memoSquare.get(c);
                    } else{
                        squareC = (int) Math.pow(c, 2);
                        memoSquare.put(c, squareC);
                    }
                    considered.add(a + "-" + b);
                    considered.add(b + "-" + a);
                    if (squareA+squareB == squareC) {
                        count++;
                    }
                }



            }

        }
        return count;


    }
}

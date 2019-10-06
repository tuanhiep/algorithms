package tuanhiep.usa.algo.others;

import java.util.Comparator;

/**
 * See how to implement comparator to compare objects
 */
public class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        }
        if (p1.score > p2.score) {
            return 1;
        } else {
            return -1;
        }


    }
}

class Player {
    public double score;
    public String name;

    public Player(double score, String name) {
        this.score = score;
        this.name = name;
    }


}
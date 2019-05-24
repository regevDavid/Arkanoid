package highscores;

import java.io.Serializable;

/**
 * The class is a representation of a score.
 *
 * @version 29.05.2018.
 * @author David Regev.
 */
public class ScoreInfo implements Serializable {
    private String name;
    private Integer score;

    /**
     * constructor.
     *
     * @param name - name of the player.
     * @param score - score of the current play.
     */
    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * getter.
     *
     * @return - the name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter.
     *
     * @return - the score of the current play.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * prints a score information.
     *
     * @param i - the rank of the scoreInfo.
     */
    public void print(int i) {
        System.out.println("Rank (" + i + "): name: " + this.getName() + "score: " + this.getScore());
    }
}

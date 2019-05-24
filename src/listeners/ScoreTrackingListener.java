package listeners;

import sprites.Ball;
import sprites.Block;

/**
 * The class tracking after the score of the player in the game.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter - the score of the player.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * getter.
     *
     * @return - the current score.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * The method updates the score according to the hit.
     *
     * @param beingHit - the block hitted.
     * @param hitter - the ball hitted the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       if (beingHit.getNumOfHits() != 0) {
           this.getCurrentScore().increase(5);
       } else {
           this.getCurrentScore().increase(10);
       }
    }

}

package listeners;
import levels.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * The class removes a ball if it got out of the screen.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter counter;

    /**
     * The method removes a ball when its counter equals 0.
     *
     * @param game          - the game of the blocks.
     * @param removedBalls - number of blocks already removed.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.counter = removedBalls;
    }

    /**
     * The method is called whenever the block is hitted.
     *
     * @param beingHit - the block hitted.
     * @param hitter   - the ball that hitted the block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        this.game.getBallsCounter().decrease(1);
    }
}

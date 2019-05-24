package listeners;
import levels.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author David Regev.
 * @version 14.05.2018.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter counter;

    /**
     * The method removes a block when its counter equals 0.
     *
     * @param game          - the game of the blocks.
     * @param removedBlocks - number of blocks already removed.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.counter = removedBlocks;
    }

    /**
     * The method is called whenever the block is hitted.
     *
     * @param beingHit - the block hitted.
     * @param hitter   - the ball that hitted the block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getNumOfHits() == 0) {
            for (int i = 0; i < beingHit.getHitListeners().size(); i++) {
                beingHit.removeHitListener(beingHit.getHitListeners().get(i));
            }
            beingHit.removeFromGame(this.game);
            this.game.getBlocksCounter().decrease(1);
            this.game.getScoreIndicator().getScore().increase(10);
        } else {
            this.game.getScoreIndicator().getScore().increase(5);
        }
    }
}
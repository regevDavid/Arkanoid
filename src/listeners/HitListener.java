package listeners;

import sprites.Ball;
import sprites.Block;

/**
 * The interface "makes" an object a listener of hits in the game.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public interface HitListener {
    /**
     * The method is called whenever the block is hitted.
     *
     *
     * @param beingHit - the block hitted.
     * @param hitter - the ball that hitted the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}

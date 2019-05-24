package sprites;
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import levels.GameLevel;
import listeners.Counter;

import java.awt.Color;

/**
 * The class tracks the lives of the player.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public class LivesIndicator implements Sprite {
    private Block headBlock;
    private Counter lives;

    /**
     * constructor.
     *
     * @param lives - number of lives.
     */
    public LivesIndicator(Counter lives) {
        this.headBlock = new Block(new Rectangle(new Point(0, 0), 800, 20));
        this.lives = lives;
    }

    /**
     * getter.
     *
     * @return - number of lives.
     */
    public Counter getLives() {
        return lives;
    }

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(20, 17, "Lives: " + String.valueOf(this.getLives().getValue()), 15);
    }

    /**
     * The function adds a sprite to a game.
     *
     * @param g - the game to add the sprite to.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The function removes a sprite from a game.
     *
     * @param g - the game to remove the sprite from.
     */
    @Override
    public void removeFromGame(GameLevel g) {

    }

    /**
     * The function notifies the sprites that time has passed.
     *
     * @param dt - speed balance.
     */
    @Override
    public void timePassed(double dt) {

    }
}
package sprites;
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import levels.GameLevel;
import listeners.Counter;

import java.awt.Color;

/**
 * The class displays the score of the player.
 *
 * @version 14.05.2018.
 * @author David Regev.
 */
public class ScoreIndicator implements Sprite {
    private Block scoreBlock;
    private Counter score;

    /**
     * constructor.
     *
     * @param score - the score.
     */
    public ScoreIndicator(Counter score) {
        this.scoreBlock = new Block(new Rectangle(new Point(0, 0), 800, 20));
        this.score = score;
    }

    /**
     * getter.
     *
     * @return - the current score.
     */
    public Counter getScore() {
        return score;
    }

    /**
     * The function draws the sprite to the screen.
     *
     * @param d - the screen to draw the sprite on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        // draws the num score of the player.
        d.setColor(Color.BLACK);
        d.drawText(350, 17, "Score: " + String.valueOf(this.getScore().getValue()), 15);
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
        g.removeSprite(this);
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
